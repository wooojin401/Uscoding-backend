package com.example.uscoding.api;

import com.example.uscoding.domain.Post;
import com.example.uscoding.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    @GetMapping
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post create(@RequestBody Post req) {
        return postRepository.save(req);
    }
}
