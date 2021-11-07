/*
 * @created 02/11/2021 - 2:23 PM
 * @author vanha
 */

package com.h2s.blogsite.service.post;

import com.h2s.blogsite.dto.mapper.PostMapper;
import com.h2s.blogsite.dto.request.PostRequest;
import com.h2s.blogsite.dto.response.MessageResponse;
import com.h2s.blogsite.dto.response.PostResponse;
import com.h2s.blogsite.entity.Post;
import com.h2s.blogsite.entity.User;
import com.h2s.blogsite.exception.UserNotExistException;
import com.h2s.blogsite.repository.PostRepository;
import com.h2s.blogsite.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private final PostMapper postMapper;

    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userRepository = userRepository;
    }

    @Override
    public PostResponse savePost(PostRequest postRequest) {
        Assert.notNull(postRequest,"Request must not be null");
        Optional<User> u = userRepository.findById(postRequest.getUserId());
        if(!u.isPresent()){
            throw new UserNotExistException("User is not exist");
        }
        Post p = postMapper.PostRequestToEntity(postRequest);
        p.setUser(u.get());
        p = postRepository.save(p);
        return postMapper.PostEntityToResponse(p);
    }
}
