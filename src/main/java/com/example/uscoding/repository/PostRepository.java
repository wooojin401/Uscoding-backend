package com.example.uscoding.repository;

import com.example.uscoding.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> { }
