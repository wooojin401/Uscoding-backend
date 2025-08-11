package com.example.uscoding;

import com.example.uscoding.PostRequestDto;
import com.example.uscoding.Content;
import com.example.uscoding.ContentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    private final ContentService service;

    public ContentController(ContentService service) {
        this.service = service;
    }

    @PostMapping
    public Content create(@RequestBody PostRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Content> list() {
        return service.findAll();
    }
}