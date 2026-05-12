package com.example.mySecondcrud.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mySecondcrud.dto.LibraryRequestDto;
import com.example.mySecondcrud.dto.LibraryResponseDto;
import com.example.mySecondcrud.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
    
    @Autowired
    private LibraryService service;

    //add book
    @PostMapping
    public LibraryResponseDto addBook(@RequestBody LibraryRequestDto reqDto){

        return service.addBook(reqDto);
    }
    // get all books
    @GetMapping
    public List<LibraryResponseDto> getAllBooks(){

        return service.getAllBooks();
    }

    // get book by id
    @GetMapping("/{id}")
    public LibraryResponseDto getBookById(@PathVariable int id){

        return service.getBookById(id);
    }

    // update book
    @PutMapping("/{id}")
    public LibraryResponseDto updateBook(@PathVariable int id,@RequestBody LibraryRequestDto reqDto){

        return service.updateBook(id, reqDto);
    }

    // delete book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){

        return service.deleteBook(id);
    }
}
