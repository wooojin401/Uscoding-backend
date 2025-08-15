package com.example.uscoding.api;

import com.example.uscoding.dto.LoginRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto req, HttpServletRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        request.getSession(true); // 세션 생성 → JSESSIONID 쿠키 발급
       // Map<String,String> result = Map.of("message", "로그인성공");
        return ResponseEntity.ok(Map.of("message", "로그인성공" ));
    }
}
