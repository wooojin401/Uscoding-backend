package com.example.uscoding;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:3000") // 프론트 포트 허용
public class RegisterController {

    @PostMapping
    public void receivePost(@RequestBody RegisgerRequestDto dto) {
        System.out.println("이메일: " + dto.getEmail());
        System.out.println("비번.: " + dto.getPassword());
        System.out.println("닉네임: " + dto.getNickname());
    }
}
