package com.example.uscoding.content;

import com.example.uscoding.PostRequestDto;
import com.example.uscoding.content.Content;
import com.example.uscoding.content.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentRepository contentRepository;

    @PostMapping
    public ResponseEntity<String> saveContent(@RequestBody ContentEntity content) {
        contentRepository.save(content);
        return ResponseEntity.ok("저장 완료");
    }
}
