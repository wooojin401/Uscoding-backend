package com.example.uscoding;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000") // 프론트 포트 허용
public class PostController {

    @PostMapping
    public void receivePost(@RequestBody PostRequestDto     dto) {
        System.out.println("주제2: " + dto.getTitle());
        System.out.println("코드3: " + dto.getCode());
        System.out.println("설명2: " + dto.getContent());
        System.out.println("카테고리: " + dto.getCategory());
    }
}
