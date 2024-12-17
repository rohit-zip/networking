package com.gn128.networking.service;

import com.gn128.networking.entity.Post;
import com.gn128.networking.entity.User;
import com.gn128.networking.exception.BadRequestException;
import com.gn128.networking.payload.ModuleResponse;
import com.gn128.networking.payload.PostRequest;
import com.gn128.networking.repository.PostRepository;
import com.gn128.networking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public ModuleResponse addPost(PostRequest postRequest, Integer userId) {
        if (postRequest.getTitle().length() > 200) {
            throw new BadRequestException("Title exceeds 200 characters");
        }
        if (postRequest.getDescription().length() > 7000) {
            throw new BadRequestException("Description exceeds 7000 characters");
        }
        if (words(postRequest.getTitle()) > 25) {
            throw new BadRequestException("Title exceeds 25 words");
        }
        if (words(postRequest.getDescription()) > 400) {
            throw new BadRequestException("Description exceeds 400 words");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        Post post = Post
                .builder()
                .title(postRequest.getTitle())
                .description(postRequest.getDescription())
                .createdAt(new Date())
                .updatedAt(new Date())
                .user(user)
                .build();
        Post postResponse = postRepository.save(post);
        return ModuleResponse.builder().message("Post Added").id(String.valueOf(postResponse.getPostId())).build();
    }

    private int words(String data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }
        String[] wordsArray = data.split("\\s+");
        return (int) Arrays.stream(wordsArray)
                .filter(word -> !word.isEmpty())
                .count();
    }
}
