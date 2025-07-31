package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.UserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(User user) {
        userGateway.create(user);
    }
}