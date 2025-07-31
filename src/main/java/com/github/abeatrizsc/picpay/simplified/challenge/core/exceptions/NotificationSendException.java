package com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions;

public class NotificationSendException extends RuntimeException {
    public NotificationSendException() {
        super("An error occurred while attempting to send the notification.");
    }
}
