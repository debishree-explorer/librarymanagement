package com.example.mySecondcrud.utility;

import org.springframework.stereotype.Component;

import com.example.mySecondcrud.dto.LibraryRequestDto;
import com.example.mySecondcrud.dto.LibraryResponseDto;
import com.example.mySecondcrud.entity.LibraryEntity;

@Component
public class LibraryMapper {
    
    //requestdto --> entity
    public LibraryEntity toEntity(LibraryRequestDto dto){

        LibraryEntity entity = new LibraryEntity();

        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPrice(dto.getPrice());

        return entity;
    }

    //entity --> responsedto
    public LibraryResponseDto toDto(LibraryEntity entity){

        LibraryResponseDto dto = new LibraryResponseDto();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAuthor(entity.getAuthor());
        dto.setPrice(entity.getPrice());

        return dto;
    }
}
