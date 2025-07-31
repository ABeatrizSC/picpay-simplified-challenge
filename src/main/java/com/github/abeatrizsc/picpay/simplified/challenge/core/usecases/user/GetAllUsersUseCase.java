package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.UserResponseDto;

import java.util.List;

public interface GetAllUsersUseCase {
    List<UserResponseDto> execute();
}
