package com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.jpa;

import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
}
