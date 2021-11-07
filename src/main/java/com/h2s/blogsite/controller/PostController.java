/*
 * @created 02/11/2021 - 2:24 PM
 * @author vanha
 */

package com.h2s.blogsite.controller;

import com.h2s.blogsite.dto.request.PostRequest;
import com.h2s.blogsite.dto.response.PostResponse;
import com.h2s.blogsite.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public PostResponse createPost(@RequestBody PostRequest postRequest){
        return postService.savePost(postRequest);
    }

}
