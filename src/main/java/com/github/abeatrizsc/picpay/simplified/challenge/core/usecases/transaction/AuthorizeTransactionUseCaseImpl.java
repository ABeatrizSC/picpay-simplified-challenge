package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction;

import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.TransactionGateway;

public class AuthorizeTransactionUseCaseImpl implements AuthorizeTransactionUseCase {
    private final TransactionGateway gateway;

    public AuthorizeTransactionUseCaseImpl(TransactionGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Boolean execute() {
        return gateway.isTransactionAuthorized();
    }
}
