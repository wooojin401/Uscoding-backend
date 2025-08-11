package com.example.uscoding.content;


import com.example.uscoding.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentEntity, Long> {}