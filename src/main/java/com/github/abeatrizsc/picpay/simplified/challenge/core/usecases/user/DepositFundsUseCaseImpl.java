package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.DepositFundsRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.UserGateway;

public class DepositFundsUseCaseImpl implements DepositFundsUseCase {
    private final UserGateway userGateway;

    public DepositFundsUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(DepositFundsRequestDto depositDto) {
        return userGateway.depositFunds(depositDto);
    }
}
