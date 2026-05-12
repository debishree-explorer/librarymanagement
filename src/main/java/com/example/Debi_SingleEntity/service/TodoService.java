package com.example.Debi_SingleEntity.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Debi_SingleEntity.dto.TodoRequestDto;
import com.example.Debi_SingleEntity.dto.TodoResponseDto;
import com.example.Debi_SingleEntity.entity.Todo;
import com.example.Debi_SingleEntity.repository.TodoRepository;
import com.example.Debi_SingleEntity.utility.TodoMapper;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repo;

    @Autowired
    private TodoMapper map;

    //create
     public TodoResponseDto createTodo(TodoRequestDto dto){

        Todo todo = map.toEntity(dto);
        Todo saved = repo.save(todo);

        return map.toDto(saved);
    }

    //update 
    public TodoResponseDto updateTodo(Long id, TodoRequestDto dto){
    Todo todo = repo.findById(id)
                    .orElseThrow(()-> new RuntimeException("todo not found"));

        todo.setName(dto.getName());
        todo.setDescription(dto.getDescription());
        todo.setCompleted(dto.isCompleted());
        
        Todo saved = repo.save(todo);

        return map.toDto(saved);            
                          
    }

    //findbyid
    public TodoResponseDto getTodoByid(Long id){

        Todo todo = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Todo not found"));

        return map.toDto(todo);
    }

    //findAll
    public List<TodoResponseDto> getAllTodos(){

    List<TodoResponseDto> resList = new ArrayList<>();
    List<Todo> todoList = repo.findAll();

    for(Todo todo : todoList){

        resList.add(map.toDto(todo));
    }

    return resList;
}
    //delete
    public TodoResponseDto DeleteTodo(Long id){

        Todo todo = repo.findById(id)
                        .orElseThrow(()-> new RuntimeException("not found"));
        
        TodoResponseDto dto = map.toDto(todo);
        repo.deleteById(id);
        return dto;
    }


}
