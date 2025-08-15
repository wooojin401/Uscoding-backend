package com.example.uscoding.api;

import com.example.uscoding.domain.UserAccount;
import com.example.uscoding.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserAccountRepository userRepo;

    // 현재 로그인한 사용자 정보 반환
    @GetMapping("/api/me")
    public UserAccount me(Authentication authentication) {
        String nickname = authentication.getName(); // 로그인 시 설정한 username 값
        return userRepo.findByNickname(nickname)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

    }
}