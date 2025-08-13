package com.example.uscoding.Service;

import com.example.uscoding.domain.UserAccount;
import com.example.uscoding.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username 파라미터에 '이메일'이 들어온다고 가정
        UserAccount user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("이메일 없음: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getNickname())  // 로그인 후 표시 이름
                .password(user.getPassword())      // DB의 BCrypt 해시
                .roles("USER")                     // 고정 권한
                .build();
    }
}
