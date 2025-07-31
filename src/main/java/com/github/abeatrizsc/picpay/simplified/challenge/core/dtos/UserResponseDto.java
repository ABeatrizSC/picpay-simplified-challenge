package com.github.abeatrizsc.picpay.simplified.challenge.core.dtos;

import com.github.abeatrizsc.picpay.simplified.challenge.core.enums.UserTypeEnum;

public record UserResponseDto(String fullName, UserTypeEnum userType, String email) {
}
