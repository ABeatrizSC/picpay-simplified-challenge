package com.github.abeatrizsc.picpay.simplified.challenge.infra.mappers;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;
import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.UserResponseDto;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.dtos.UserCreateRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.UserEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserMapper {
    public UserEntity userToEntity(User user) {
        return new UserEntity(null, user.userType(), user.fullName(), user.document(), user.email(), user.password(), user.balance());
    }

    public User entityToUser(UserEntity entity) {
        return new User(entity.getId(), entity.getFullName(), entity.getUserType(), entity.getDocument(), entity.getEmail(), entity.getPassword(), entity.getBalance());
    }

    public User userCreateToUser(UserCreateRequestDto userCreateRequestDto) {
        return new User(null, userCreateRequestDto.fullName(), userCreateRequestDto.userType(), userCreateRequestDto.document(), userCreateRequestDto.email(), userCreateRequestDto.password(), BigDecimal.valueOf(0.00));
    }

    public UserResponseDto userEntityToResponse(UserEntity entity) {
        return new UserResponseDto(entity.getFullName(), entity.getUserType(), entity.getEmail());
    }
}
