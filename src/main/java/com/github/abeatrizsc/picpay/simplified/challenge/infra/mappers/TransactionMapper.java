package com.github.abeatrizsc.picpay.simplified.challenge.infra.mappers;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionDto;
import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionEntity dtoToEntity(TransactionDto dto) {
        return new TransactionEntity(null, dto.amount(), dto.sender(), dto.receiver());
    }
}
