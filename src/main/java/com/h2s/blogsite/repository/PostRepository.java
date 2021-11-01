package com.h2s.blogsite.repository;

import com.h2s.blogsite.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}