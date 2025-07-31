package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.enums.UserTypeEnum;
import com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions.InsufficientBalanceException;
import com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions.UnauthorizedTransactionException;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.TransactionGateway;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.UserGateway;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private final TransactionGateway transactionGateway;
    private final UserGateway userGateway;

    public CreateTransactionUseCaseImpl(TransactionGateway gateway, UserGateway userGateway) {
        this.transactionGateway = gateway;
        this.userGateway = userGateway;
    }

    @Override
    public void execute(TransactionDto transaction) {
        User sender = userGateway.getById(transaction.sender());
        User receiver = userGateway.getById(transaction.receiver());

        if (!sender.userType().equals(UserTypeEnum.CUSTOMER)) {
            throw new UnauthorizedTransactionException();
        } else if (sender.balance().compareTo(transaction.amount()) < 0) {
            throw new InsufficientBalanceException();
        }

        if (transactionGateway.isTransactionAuthorized()) {
            transactionGateway.createTransaction(transaction);
            transactionGateway.notifyTransaction(receiver.email());
        }
    }
}