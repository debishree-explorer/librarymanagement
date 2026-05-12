package com.example.Debi_SingleEntity.controller;

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

import com.example.Debi_SingleEntity.dto.TodoRequestDto;
import com.example.Debi_SingleEntity.dto.TodoResponseDto;
import com.example.Debi_SingleEntity.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    
    @Autowired
    private TodoService service;

    @PostMapping //create
    public TodoResponseDto createtodo(@RequestBody TodoRequestDto dto){
        return service.createTodo(dto);
    }

    @GetMapping //getall
    public List<TodoResponseDto> getAllTodos(){
        return service.getAllTodos();
    }

    @GetMapping("/{id}") //getbyid
    public TodoResponseDto getTodoByid(@PathVariable Long id){
        return service.getTodoByid(id);
    }

    @PutMapping("/{id}") //update
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto dto){
        return service.updateTodo(id, dto);
    }

    @DeleteMapping("/{id}")//delete
    public TodoResponseDto DeleteTodo(@PathVariable Long id){
        return service.DeleteTodo(id);
    }
}
