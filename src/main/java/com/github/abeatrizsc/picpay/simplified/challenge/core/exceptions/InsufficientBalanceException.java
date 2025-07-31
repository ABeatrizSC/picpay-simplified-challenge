package com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions;

public class InsufficientBalanceException extends BusinessException {
    public InsufficientBalanceException() {
        super("The available balance is insufficient to complete the transfer.");
    }
}
