package com.github.abeatrizsc.picpay.simplified.challenge.infra.mappers;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionEntity dtoToEntity(TransactionRequestDto dto) {
        return new TransactionEntity(null, dto.amount(), dto.sender(), dto.receiver());
    }
}
