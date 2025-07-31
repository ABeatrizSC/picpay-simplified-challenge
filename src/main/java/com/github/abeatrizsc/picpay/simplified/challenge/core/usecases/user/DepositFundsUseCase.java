package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.DepositFundsRequestDto;

public interface DepositFundsUseCase {
    User execute(DepositFundsRequestDto depositDto);
}
