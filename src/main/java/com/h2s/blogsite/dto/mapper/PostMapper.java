/*
 * @created 02/11/2021 - 2:37 PM
 * @author vanha
 */

package com.h2s.blogsite.dto.mapper;

import com.h2s.blogsite.dto.request.PostRequest;
import com.h2s.blogsite.dto.response.PostResponse;
import com.h2s.blogsite.dto.response.UserResponse;
import com.h2s.blogsite.entity.Post;
import com.h2s.blogsite.entity.User;
import com.h2s.blogsite.repository.PostRepository;
import com.h2s.blogsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PostMapper {

    private final PostRepository postRepository;

    private Function<PostRequest,Post> convertPostRequestToPost = p -> {
        Post temp = new Post();
        temp.setContent(p.getContent());
        temp.setTitle(p.getTitle());
        return temp;
    };

    private Function<Post,PostResponse> convertPostToPostResponse = p -> {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(p.getUser().getId());
        userResponse.setEmail(p.getUser().getEmail());
        userResponse.setFullName(p.getUser().getFullName());
        PostResponse temp = PostResponse.builder()
                .title(p.getTitle())
                .content(p.getContent())
                .post_id(p.getId())
                .user(userResponse)
                .createAt(p.getCreateAt()).build();
        return temp;
    };

    public PostMapper(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post PostRequestToEntity(PostRequest postRequest){
        return convertPostRequestToPost.apply(postRequest);
    }

    public PostResponse PostEntityToResponse(Post post){
        return convertPostToPostResponse.apply(post);
    }

}
