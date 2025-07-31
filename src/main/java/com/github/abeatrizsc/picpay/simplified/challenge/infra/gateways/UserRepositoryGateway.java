package com.github.abeatrizsc.picpay.simplified.challenge.infra.gateways;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.DepositFundsRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.UserResponseDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.exceptions.UserNotFoundException;
import com.github.abeatrizsc.picpay.simplified.challenge.core.gateways.UserGateway;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.mappers.UserMapper;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.UserEntity;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.jpa.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::userEntityToResponse).toList();
    }

    @Override
    public User getById(String id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found."));
        
        return userMapper.entityToUser(userEntity);
    }

    @Override
    @Transactional
    public void create(User user) {
        userRepository.save(userMapper.userToEntity(user));
    }

    @Override
    @Transactional
    public User depositFunds(DepositFundsRequestDto depositDto) {
        UserEntity userEntity = userRepository.getById(depositDto.userId());
        userEntity.setBalance(userEntity.getBalance().add(depositDto.amount()));
        userRepository.save(userEntity);

        return userMapper.entityToUser(userEntity);
    }
}