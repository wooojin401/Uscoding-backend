package com.example.uscoding;


import com.example.uscoding.Content;
import com.example.uscoding.ContentRepository;
import com.example.uscoding.PostRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContentService {
    private final ContentRepository repo;

    public ContentService(ContentRepository repo) {
        this.repo = repo;
    }

    public Content create(PostRequestDto dto) {
        Content c = new Content(dto.getTitle(), dto.getCode(), dto.getContent(), dto.getCategory());
        return repo.save(c);
    }

    @Transactional(readOnly = true)
    public List<Content> findAll() {
        return repo.findAll();
    }
}