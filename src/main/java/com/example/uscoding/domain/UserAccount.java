    package com.example.uscoding.domain;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import lombok.*;

    @Entity
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class UserAccount {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 120)
        private String email;
        @JsonIgnore
        @Column(nullable = false, length = 120)
        private String password;

        @Column(nullable = false, length = 60)
        private String nickname;
    }
