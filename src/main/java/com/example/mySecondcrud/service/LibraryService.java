package com.example.mySecondcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mySecondcrud.dto.LibraryRequestDto;
import com.example.mySecondcrud.dto.LibraryResponseDto;
import com.example.mySecondcrud.entity.LibraryEntity;
import com.example.mySecondcrud.repository.LibraryRepository;
import com.example.mySecondcrud.utility.LibraryMapper;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository repo;

    @Autowired
    private LibraryMapper map;

    //add book
    public LibraryResponseDto addBook(LibraryRequestDto reqDto){

        LibraryEntity entity = map.toEntity(reqDto);
        LibraryEntity savedEntity = repo.save(entity);
        return map.toDto(savedEntity);

    }
    //get book by id
     public LibraryResponseDto getBookById(int id){

        LibraryEntity entity = repo.findById(id).orElse(null);

        return map.toDto(entity);
    }

        public List<LibraryResponseDto> getAllBooks(){

        List<LibraryEntity> books = repo.findAll();
        List<LibraryResponseDto> dtoList = new ArrayList<>();
        
        for(LibraryEntity book : books){
        dtoList.add(map.toDto(book));
        }
        return dtoList;
    }
    // update book
    public LibraryResponseDto updateBook(int id,LibraryRequestDto reqDto){

        LibraryEntity oldBook = repo.findById(id).orElse(null);

        oldBook.setTitle(reqDto.getTitle());
        oldBook.setAuthor(reqDto.getAuthor());
        oldBook.setPrice(reqDto.getPrice());

        LibraryEntity updatedBook = repo.save(oldBook);

        return map.toDto(updatedBook);
    }

    // delete book
    public String deleteBook(int id){

        repo.deleteById(id);

        return "Book Deleted Successfully";
    }
}
