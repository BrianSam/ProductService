package com.brian.productservice.advices;

import com.brian.productservice.dtos.exception.ExceptionDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptions {
    @ExceptionHandler(Exception.class)
    public ExceptionDto handleException(RuntimeException exception) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(exception.getMessage());
        exceptionDto.setStatus("error");
        return exceptionDto;

    }
}
