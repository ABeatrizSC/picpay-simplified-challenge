package com.github.abeatrizsc.picpay.simplified.challenge.core.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record TransactionDto(
        @PositiveOrZero(message = "Invalid amount.")
        @NotNull(message = "Invalid amount.")
        BigDecimal amount,
        @NotBlank(message = "Sender is required.")
        String sender,
        @NotBlank(message = "Receiver is required.")
        String receiver)
{}
