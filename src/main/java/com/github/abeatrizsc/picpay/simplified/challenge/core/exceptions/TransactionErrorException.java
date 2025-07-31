package com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions;

public class TransactionErrorException extends RuntimeException {
    public TransactionErrorException() {
        super("An error occurred during the transaction. Please try again.");
    }
}
