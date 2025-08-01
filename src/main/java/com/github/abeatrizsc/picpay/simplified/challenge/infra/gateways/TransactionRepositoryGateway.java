package com.github.abeatrizsc.picpay.simplified.challenge.infra.gateways;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions.NotificationSendException;
import com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions.TransactionErrorException;
import com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions.UserNotFoundException;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.TransactionGateway;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.dtos.external.services.authorizationtransaction.ExternalAuthorizationResponseDto;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.dtos.external.services.notifytransaction.ExternalNotificationResponseDto;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.mappers.TransactionMapper;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.UserEntity;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.jpa.TransactionRepository;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.jpa.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Component
@AllArgsConstructor
public class TransactionRepositoryGateway implements TransactionGateway {
    private final RestTemplate restTemplate;
    private final TransactionRepository repository;
    private final UserRepository userRepository;
    private final TransactionMapper mapper;

    @Override
    @Transactional
    public void createTransaction(TransactionRequestDto transaction) {
        UserEntity sender = userRepository.findById(transaction.sender()).orElseThrow(() -> new UserNotFoundException("Invalid sender."));
        UserEntity receiver = userRepository.findById(transaction.receiver()).orElseThrow(() -> new UserNotFoundException("Invalid receiver."));

        BigDecimal newSenderBalance = sender.getBalance().subtract(transaction.amount());
        sender.setBalance(newSenderBalance);

        BigDecimal newReceiverBalance = receiver.getBalance().add(transaction.amount());
        receiver.setBalance(newReceiverBalance);

        userRepository.save(sender);
        userRepository.save(receiver);

        repository.save(mapper.dtoToEntity(transaction));
    }


    @Override
    @Retryable(retryFor = TransactionErrorException.class, maxAttempts = 5, backoff = @Backoff(delay = 100))
    public Boolean isTransactionAuthorized() {
        try {
            ResponseEntity<ExternalAuthorizationResponseDto> response = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", ExternalAuthorizationResponseDto.class);
        } catch (Exception e) {
            log.info("Transaction Authorization Retry Number: "+ RetrySynchronizationManager.getContext().getRetryCount());
            throw new TransactionErrorException();
        }

        return true;
    }

    @Override
    @Retryable(retryFor = NotificationSendException.class, maxAttempts = 5, backoff = @Backoff(delay = 100))
    public void notifyTransaction(String receiverEmail) {
        try {
            ExternalNotificationResponseDto response = restTemplate.postForObject("https://util.devi.tools/api/v1/notify", receiverEmail, ExternalNotificationResponseDto.class);
        } catch (Exception e) {
            log.info("Notification Retry Number: "+ RetrySynchronizationManager.getContext().getRetryCount());
            throw new NotificationSendException();
        }
    }
}