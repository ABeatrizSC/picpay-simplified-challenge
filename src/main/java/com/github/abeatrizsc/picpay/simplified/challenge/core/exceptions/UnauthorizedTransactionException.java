package com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions;

public class UnauthorizedTransactionException extends BusinessException {
    public UnauthorizedTransactionException() {
        super("Merchants are not allowed to perform transfers.");
    }
}
