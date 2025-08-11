package com.example.uscoding.content;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "content_table")
@Data
public class ContentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String code;
    private String content;
    private String category;
}
