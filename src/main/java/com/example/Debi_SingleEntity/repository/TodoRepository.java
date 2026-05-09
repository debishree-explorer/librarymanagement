package com.example.Debi_SingleEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Debi_SingleEntity.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
