package com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.jpa;

import com.github.abeatrizsc.picpay.simplified.challenge.infra.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}