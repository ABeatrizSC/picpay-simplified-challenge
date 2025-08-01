package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionRequestDto;

public interface CreateTransactionUseCase {
    void execute(TransactionRequestDto transaction);
}
