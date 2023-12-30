package com.blog.controller;

import com.blog.payload.PostDto;
import com.blog.service.PostService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

   private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }
   @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);

    }
    @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<String>deletePost(@PathVariable long id){
      postService.deletePost(id);
       return new ResponseEntity<>("Posts Is Delete",HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
      List<PostDto> postDtos=postService.getAllPosts();
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }
   public void test(){

   }
   
}
