-- `blog-site`.roles definition

CREATE TABLE `roles` (
                         `role_id` int NOT NULL AUTO_INCREMENT,
                         `role_name` varchar(50) NOT NULL,
                         PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `blog-site`.users definition

CREATE TABLE `users` (
                         `user_id` varchar(50) NOT NULL,
                         `email` varchar(50) NOT NULL,
                         `password` varchar(50) NOT NULL,
                         `full_name` varchar(50) NOT NULL,
                         PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `blog-site`.posts definition

CREATE TABLE `posts` (
                         `post_id` varchar(50) NOT NULL,
                         `title` text NOT NULL,
                         `content` text NOT NULL,
                         `create_at` datetime DEFAULT NULL,
                         `user_id` varchar(50) DEFAULT NULL,
                         PRIMARY KEY (`post_id`),
                         KEY `user_id` (`user_id`),
                         CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `blog-site`.users_roles definition

CREATE TABLE `users_roles` (
                               `user_role_id` int NOT NULL AUTO_INCREMENT,
                               `user_id` varchar(50) DEFAULT NULL,
                               `role_id` int DEFAULT NULL,
                               PRIMARY KEY (`user_role_id`),
                               KEY `user_id` (`user_id`),
                               KEY `role_id` (`role_id`),
                               CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
                               CONSTRAINT `users_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;