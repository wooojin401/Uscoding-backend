package com.example.uscoding.api;

import com.example.uscoding.domain.Post;
import com.example.uscoding.domain.UserAccount;
import com.example.uscoding.dto.PostRequestDto;
import com.example.uscoding.dto.PostResponseDto;
import com.example.uscoding.repository.PostRepository;
import com.example.uscoding.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostRepository postRepository;
    private final UserAccountRepository userAccountRepository;

    // 글 생성
    @PostMapping("/posts")
    public ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto req) {
        // 1) 작성자 확인
        UserAccount user = userAccountRepository.findById(req.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // 2) 날짜 파싱
        LocalDate date = LocalDate.parse(req.getDate()); // "YYYY-MM-DD"

        // 3) 엔티티 생성
        Post post = Post.builder()
                .user(user)
                .title(req.getTitle())
                .code(req.getCode())
                .content(req.getContent())
                .category(req.getCategory())
                .date(date)
                .likes(req.getLikes() == null ? 0L : req.getLikes())
                .build();

        // 4) 저장
        Post saved = postRepository.save(post);

        // 5) 생성된 id 반환
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new PostResponseDto(saved.getId()));
    }

    // 전체 조회 (간단 확인용)
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postRepository.findAll());
    }
}
