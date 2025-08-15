package com.example.uscoding.api;

import com.example.uscoding.domain.UserAccount;
import com.example.uscoding.dto.RegisterRequestDto;
import com.example.uscoding.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegisterController {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder; // 추가

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto req) {
        UserAccount user = new UserAccount();
        user.setEmail(req.getEmail());

        // 비밀번호 해시 처리
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        user.setNickname(req.getNickname());

        userRepo.save(user);

        return ResponseEntity.ok("회원가입 완료");
    }
}
