package com.example.uscoding;

import lombok.Data;

@Data
public class RegisgerRequestDto {
    private String email;
    private String password;
    private String nickname;
}
