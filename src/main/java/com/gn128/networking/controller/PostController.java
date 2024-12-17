package com.gn128.networking.controller;

import com.gn128.networking.entity.Post;
import com.gn128.networking.payload.ModuleResponse;
import com.gn128.networking.payload.PostRequest;
import com.gn128.networking.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/{userId}")
    public ResponseEntity<ModuleResponse> addPost(@RequestBody PostRequest postRequest, @PathVariable Integer userId) {
        ModuleResponse moduleResponse = postService.addPost(postRequest, userId);
        //return ResponseEntity.ok(moduleResponse);
        return new ResponseEntity<>(moduleResponse, HttpStatus.ACCEPTED);
    }
}
