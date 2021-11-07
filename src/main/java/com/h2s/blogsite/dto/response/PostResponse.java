/*
 * @created 02/11/2021 - 2:34 PM
 * @author vanha
 */

package com.h2s.blogsite.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PostResponse {
    private String post_id;
    private String title;
    private String content;
    private UserResponse user;
    private LocalDateTime createAt;
}
