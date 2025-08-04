package com.example.uscoding;
import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String code;
    private String content;
    private String category;

    // Getters and setters (또는 @Data 사용 가능)
}