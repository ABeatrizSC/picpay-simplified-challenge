package com.github.abeatrizsc.picpay.simplified.challenge.core.gateways;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.DepositFundsRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.UserResponseDto;

import java.util.List;

public interface UserGateway {
    void create(User user);
    List<UserResponseDto> getAll();
    User getById(String id);
    User depositFunds(DepositFundsRequestDto depositDto);
}
