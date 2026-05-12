package com.example.Debi_SingleEntity.utility;

import org.springframework.stereotype.Component;

import com.example.Debi_SingleEntity.dto.TodoRequestDto;
import com.example.Debi_SingleEntity.dto.TodoResponseDto;
import com.example.Debi_SingleEntity.entity.Todo;

@Component
public class TodoMapper {
    
    public Todo toEntity(TodoRequestDto dto){

        Todo newTodo = new Todo();

        newTodo.setName(dto.getName());
        newTodo.setDescription(dto.getDescription());
        newTodo.setCompleted(dto.isCompleted());

        return newTodo;
    }

    public TodoResponseDto toDto(Todo todo){

        TodoResponseDto dto = new TodoResponseDto();

        dto.setName(todo.getName());
        dto.setDescription(todo.getDescription());
        dto.setCompleted(todo.isCompleted());
        dto.setId(todo.getId());

        return dto;
    }
}
