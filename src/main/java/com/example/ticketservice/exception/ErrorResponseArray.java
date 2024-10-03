package com.example.ticketservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponseArray {
    private String title;
    private List<String> details;
    private String instance;
}
