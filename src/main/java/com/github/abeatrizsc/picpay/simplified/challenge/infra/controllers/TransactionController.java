package com.github.abeatrizsc.picpay.simplified.challenge.infra.controllers;

import com.github.abeatrizsc.picpay.simplified.challenge.core.dtos.TransactionRequestDto;
import com.github.abeatrizsc.picpay.simplified.challenge.core.usecases.transaction.CreateTransactionUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@AllArgsConstructor
public class TransactionController {
    private final CreateTransactionUseCase createTransaction;

    @PostMapping
    public ResponseEntity createTransaction(@RequestBody @Valid TransactionRequestDto transaction) {
        createTransaction.execute(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
