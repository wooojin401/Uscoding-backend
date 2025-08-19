package com.example.uscoding.dto;

import com.example.uscoding.domain.Post;
import com.example.uscoding.domain.UserAccount;
import lombok.Builder;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record PostResponseDto(
        Long id,
        UserAccount user,
        String title,
        String code,
        String content,
        String category,
        LocalDate date,
        Long likes
) {
    @Builder
    public PostResponseDto {}

    public static PostResponseDto from(Post p){
        return new PostResponseDto(
                p.getId(),
                p.getUser(),
                p.getTitle(),
                p.getCode(),
                p.getContent(),
                p.getCategory(),
                p.getDate() != null ? p.getDate() : null ,
                p.getLikes()
        );
    }
}