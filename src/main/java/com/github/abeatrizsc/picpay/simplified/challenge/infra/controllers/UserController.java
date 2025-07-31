package com.github.abeatrizsc.picpay.simplified.challenge.infra.controllers;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.DepositFundsRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.UserResponseDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user.CreateUserUseCase;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user.DepositFundsUseCase;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user.GetAllUsersUseCase;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.dtos.UserCreateDto;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.mappers.UserMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final CreateUserUseCase createUser;
    private final GetAllUsersUseCase getAllUsers;
    private final DepositFundsUseCase depositFunds;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserResponseDto> getAll() {
        return getAllUsers.execute();
    }

    @PostMapping
    public void createUser(@RequestBody @Valid UserCreateDto user) {
        createUser.execute(userMapper.userCreateToUser(user));
    }

    @PostMapping("/deposits")
    public User depositFunds(@RequestBody @Valid DepositFundsRequestDto depositFundsRequestDto) {
        return depositFunds.execute(depositFundsRequestDto);
    }
}
