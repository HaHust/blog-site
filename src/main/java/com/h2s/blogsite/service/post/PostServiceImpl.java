/*
 * @created 02/11/2021 - 2:23 PM
 * @author vanha
 */

package com.h2s.blogsite.service.post;

import com.h2s.blogsite.dto.request.PostRequest;
import com.h2s.blogsite.dto.response.PostResponse;
import com.h2s.blogsite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostResponse savePost(PostRequest postRequest) {

    }
}
