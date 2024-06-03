package com.ohgiraffers.jwtsecurity.user.repository;

import com.ohgiraffers.jwtsecurity.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
