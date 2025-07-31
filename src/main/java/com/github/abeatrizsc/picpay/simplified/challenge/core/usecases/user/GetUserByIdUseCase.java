package com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.user;

import com.github.abeatrizsc.picpay.simplified.challenge.core.domain.User;

public interface GetUserByIdUseCase {
    User execute(String id);
}
