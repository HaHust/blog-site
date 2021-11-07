package com.h2s.blogsite.service.post;

import com.h2s.blogsite.dto.request.PostRequest;
import com.h2s.blogsite.dto.response.PostResponse;
import org.springframework.stereotype.Service;

public interface PostService {

    PostResponse savePost(PostRequest postRequest);
}
