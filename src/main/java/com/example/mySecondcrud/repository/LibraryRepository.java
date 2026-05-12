package com.example.mySecondcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mySecondcrud.entity.LibraryEntity;

public interface LibraryRepository extends JpaRepository<LibraryEntity , Integer>{

}
