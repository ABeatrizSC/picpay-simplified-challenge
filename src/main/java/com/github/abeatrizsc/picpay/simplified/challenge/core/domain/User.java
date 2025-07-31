package com.github.abeatrizsc.picpay.simplified.challenge.core.domain;

import com.github.abeatrizsc.picpay.simplified.challenge.core.enums.UserTypeEnum;

import java.math.BigDecimal;

public record User(String id, String fullName, UserTypeEnum userType, String document, String email, String password, BigDecimal balance){}