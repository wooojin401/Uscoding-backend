package com.example.uscoding;


import jakarta.persistence.*;

@Entity
@Table(name = "content_table")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // MySQL AUTO_INCREMENT
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 50)
    private String code;

    @Lob
    private String content;

    @Column(length = 50)
    private String category;

    protected Content() {}  // JPA 기본 생성자

    public Content(String title, String code, String content, String category) {
        this.title = title;
        this.code = code;
        this.content = content;
        this.category = category;
    }

    // getter만 두어도 JPA 동작 O
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCode() { return code; }
    public String getContent() { return content; }
    public String getCategory() { return category; }

    // 필요 시 변경 메서드
    public void update(String title, String code, String content, String category) {
        this.title = title;
        this.code = code;
        this.content = content;
        this.category = category;
    }
}