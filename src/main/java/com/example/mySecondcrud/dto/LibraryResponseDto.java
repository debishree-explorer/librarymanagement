package com.example.mySecondcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LibraryResponseDto {
    
    private int id;
    private String title;
    private String author;
    private double price;
}
