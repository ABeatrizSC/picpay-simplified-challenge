package com.github.abeatrizsc.picpay.simplified.challenge.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(String id, BigDecimal amount, String sender, String receiver, LocalDateTime timestamp) {}
