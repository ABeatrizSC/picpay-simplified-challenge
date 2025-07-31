package com.github.abeatrizsc.picpay.simplified.challenge.infra.config;

import com.github.abeatrizsc.picpay.simplified.challenge.core.enums.UserTypeEnum;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.TransactionGateway;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.UserGateway;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction.AuthorizeTransactionUseCase;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction.AuthorizeTransactionUseCaseImpl;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction.CreateTransactionUseCase;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction.CreateTransactionUseCaseImpl;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user.*;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.UserEntity;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.jpa.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Configuration
@EnableRetry
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            userRepository.save(new UserEntity(
                    null,
                    UserTypeEnum.CUSTOMER,
                    "John",
                    "123.456.789-10",
                    "john@example.com",
                    "123",
                    new BigDecimal("50.00")
            ));
            userRepository.save(new UserEntity(
                    null,
                    UserTypeEnum.MERCHANT,
                    "Alice",
                    "123.456.789-11",
                    "alice@example.com",
                    "123",
                    new BigDecimal("50.00")
            ));
        };
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway) {
        return new CreateUserUseCaseImpl(userGateway);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserGateway userGateway) {
        return new GetAllUsersUseCaseImpl(userGateway);
    }

    @Bean
    public DepositFundsUseCase depositFundsUseCase(UserGateway userGateway) {
        return new DepositFundsUseCaseImpl(userGateway);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserGateway userGateway) {
        return new GetUserByIdUseCaseImpl(userGateway);
    }

    @Bean
    public AuthorizeTransactionUseCase authorizeTransactionUseCase(TransactionGateway transactionGateway) {
        return new AuthorizeTransactionUseCaseImpl(transactionGateway) {
        };
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(TransactionGateway transactionGateway, UserGateway userGateway) {
        return new CreateTransactionUseCaseImpl(transactionGateway, userGateway) {
        };
    }

}
