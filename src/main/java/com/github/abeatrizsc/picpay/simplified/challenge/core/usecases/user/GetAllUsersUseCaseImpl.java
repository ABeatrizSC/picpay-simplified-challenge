package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.UserResponseDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.UserGateway;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {
    private final UserGateway userGateway;

    public GetAllUsersUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<UserResponseDto> execute() {
        return userGateway.getAll();
    }
}
