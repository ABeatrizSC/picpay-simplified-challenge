package com.github.abeatrizsc.picpay.simplified.challenge.core.gateways;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionDto;

public interface TransactionGateway {
    void createTransaction(TransactionDto transaction);
    Boolean isTransactionAuthorized();
    void notifyTransaction(String receiverEmail);
}
