package com.example.uscoding.api;

import com.example.uscoding.domain.UserAccount;
import com.example.uscoding.dto.RegisterRequestDto;
import com.example.uscoding.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegisterController {

    private final UserAccountRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto req) {
        UserAccount user = new UserAccount(); // JPA용 기본 생성자 필요
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setNickname(req.getNickname());

        userRepo.save(user);

        return ResponseEntity.ok("회원가입 완료");
    }
}
