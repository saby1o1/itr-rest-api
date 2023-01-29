package com.interview.prep.rest.webservies.restfulwebservices.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
