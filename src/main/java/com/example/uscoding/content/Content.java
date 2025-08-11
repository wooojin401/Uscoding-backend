package com.example.uscoding.content;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Content {
    private String title;
    private String code;
    private String content;
    private String category;
}
