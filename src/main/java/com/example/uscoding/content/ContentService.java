package com.example.uscoding.content;


import com.example.uscoding.content.Content;
import com.example.uscoding.content.ContentRepository;
import com.example.uscoding.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public void saveContent(Content dto) {
        // DTO → Entity 변환
        ContentEntity entity = new ContentEntity();
        entity.setTitle(dto.getTitle());
        entity.setCode(dto.getCode());
        entity.setContent(dto.getContent());
        entity.setCategory(dto.getCategory());

        contentRepository.save(entity);
    }
}