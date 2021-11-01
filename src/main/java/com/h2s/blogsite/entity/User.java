package com.h2s.blogsite.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 50)
    private String id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;
}