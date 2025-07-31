package com.github.abeatrizsc.picpay.simplified.challenge.infra.exceptions;

import org.springframework.http.HttpStatus;

public record RestErrorMessage(
        Integer status,
        HttpStatus error,
        String message)
{}
