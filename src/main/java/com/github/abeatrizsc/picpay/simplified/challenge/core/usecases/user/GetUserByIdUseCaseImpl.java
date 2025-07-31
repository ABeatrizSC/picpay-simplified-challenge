package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.UserGateway;

public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {
    private final UserGateway gateway;

    public GetUserByIdUseCaseImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public User execute(String id) {
        return gateway.getById(id);
    }
}
