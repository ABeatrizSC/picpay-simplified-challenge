package com.github.abeatrizsc.picpay.simplified.challenge.core.gateways;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionRequestDto;

public interface TransactionGateway {
    void createTransaction(TransactionRequestDto transaction);
    Boolean isTransactionAuthorized();
    void notifyTransaction(String receiverEmail);
}
