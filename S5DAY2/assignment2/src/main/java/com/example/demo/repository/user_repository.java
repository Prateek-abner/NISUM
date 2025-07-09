package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
    String findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    String findByUsernameSecure(@Param("username") String username);
}
