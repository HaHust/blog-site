package com.h2s.blogsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSiteApplication.class, args);
    }

}
