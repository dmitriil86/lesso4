package com.example.lesson4.repository;

import com.example.lesson4.Entety.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {
}
