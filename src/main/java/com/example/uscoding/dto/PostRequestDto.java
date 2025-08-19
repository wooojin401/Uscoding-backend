package com.example.uscoding.dto;
import lombok.Data;

@Data
public class PostRequestDto {
    private Long userId;
    private String title;
    private String code;
    private String content;
    private String category;
    private String date;
    private Long likes;

    // Getters and setters (또는 @Data 사용 가능)
}