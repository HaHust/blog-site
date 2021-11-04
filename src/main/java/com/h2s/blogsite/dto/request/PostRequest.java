/*
 * @created 02/11/2021 - 2:28 PM
 * @author vanha
 */

package com.h2s.blogsite.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostRequest {
    private String title;
    private String content;
    private String userId;
}
