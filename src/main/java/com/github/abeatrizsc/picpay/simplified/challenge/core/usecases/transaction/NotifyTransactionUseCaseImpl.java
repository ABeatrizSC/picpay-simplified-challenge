package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction;

import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.TransactionGateway;

public class NotifyTransactionUseCaseImpl implements NotifyTransactionUseCase {
    private final TransactionGateway gateway;

    public NotifyTransactionUseCaseImpl(TransactionGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(String receiverEmail) {
        gateway.notifyTransaction(receiverEmail);
    }
}