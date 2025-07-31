package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionDto;

public interface CreateTransactionUseCase {
    void execute(TransactionDto transaction);
}
