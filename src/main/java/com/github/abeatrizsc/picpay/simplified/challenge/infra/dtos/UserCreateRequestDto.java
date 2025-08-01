package com.github.abeatrizsc.picpay.simplified.challenge.infra.dtos;

import com.github.abeatrizsc.picpay.simplified.challenge.core.enums.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateRequestDto(
        @NotBlank(message = "The field 'name' must not be blank.")
        String fullName,
        UserTypeEnum userType,
        @NotBlank(message = "The field 'document' must not be blank.")
        String document,
        @Email(message = "Invalid email.")
        @NotBlank(message = "The field 'email' must not be blank.")
        String email,
        @NotBlank(message = "The field 'password' must not be blank.")
        String password)
{}
