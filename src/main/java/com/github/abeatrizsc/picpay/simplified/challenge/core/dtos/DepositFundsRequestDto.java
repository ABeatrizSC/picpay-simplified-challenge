package com.github.abeatrizsc.picpay.simplified.challenge.core.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record DepositFundsRequestDto(
        @NotBlank(message = "User id is required.")
        String userId,
        @PositiveOrZero(message = "Invalid amount.")
        @NotNull(message = "Invalid amount.")
        BigDecimal amount)
{}
