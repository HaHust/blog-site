/*
 * @created 02/11/2021 - 2:37 PM
 * @author vanha
 */

package com.h2s.blogsite.mapper;

import com.h2s.blogsite.dto.request.PostRequest;
import com.h2s.blogsite.entity.Post;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Stream;

@Component
public class PostMapper {
    Function<Post,PostRequest> convertPost = postRequest -> {
        new Post(po)
    }
    public Post PostRequestToEntity(PostRequest postRequest){
        Stream
    }

}
