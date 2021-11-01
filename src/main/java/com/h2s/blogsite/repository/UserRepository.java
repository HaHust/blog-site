package com.h2s.blogsite.repository;

import com.h2s.blogsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}