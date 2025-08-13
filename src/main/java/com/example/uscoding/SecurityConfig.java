package com.example.uscoding;

import com.example.uscoding.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final MyUserDetailsService myUserDetailsService; // email로 유저 찾는 구현체

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1) CORS 허용
                .cors(cors -> {})
                // 2) 개발용으로 CSRF 비활성화 (운영 전 다시 점검 권장)
                .csrf(csrf -> csrf.disable())
                // 3) 권한 규칙
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/api/register", "/public/**", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                // 4) 폼 로그인 활성화 (기본 URL: /login)
                .formLogin(form -> form
                        // .loginPage("/login") // 커스텀 페이지 쓸 때만 지정
                        .usernameParameter("username") // 우리가 username 키로 보냄(기본값이라 생략 가능)
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)  // 성공 시 이동
                        .permitAll()
                )
                // 5) 로그아웃(선택)
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                // 6) 인증 프로바이더(유저조회+비번검증)
                .userDetailsService(myUserDetailsService);

        return http.build();
    }

    // 비밀번호 비교를 위한 인코더 (DB에는 BCrypt 해시가 있어야 함)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // CORS 상세
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        var cfg = new CorsConfiguration();
        cfg.setAllowedOrigins(List.of("http://localhost:3000"));
        cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        cfg.setAllowedHeaders(List.of("*"));
        cfg.setAllowCredentials(true); // ★ 쿠키 허용
        var src = new UrlBasedCorsConfigurationSource();
        src.registerCorsConfiguration("/**", cfg);
        return src;
    }
}
