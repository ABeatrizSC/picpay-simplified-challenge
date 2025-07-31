package com.github.abeatrizsc.picpay.simplified.challenge.infra.dtos;

import com.github.abeatrizsc.picpay.simplified.challenge.core.enums.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDto(
        @NotBlank(message = "Invalid name.")
        String fullName,
        UserTypeEnum userType,
        @NotBlank(message = "Invalid document.")
        String document,
        @Email(message = "Invalid email.")
        String email,
        @NotBlank(message = "Invalid password.")
        String password)
{}
