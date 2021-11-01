package com.h2s.blogsite.entity;

import com.h2s.blogsite.entity.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "posts", indexes = {
        @Index(name = "user_id", columnList = "user_id")
})
@Entity
@Getter
@Setter
public class Post extends DateAudit {
    @Id
    @Column(name = "post_id", nullable = false, length = 50)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}