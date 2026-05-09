package com.example.Debi_SingleEntity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequestDto {
    
    private String name;
    private String description;
    private boolean completed;
}
