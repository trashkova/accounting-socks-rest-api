package ru.trashkova.accounting.socks.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ru.trashkova.accounting.socks.dto.ErrorDetailResponse;
import ru.trashkova.accounting.socks.exception.IncorrectComparisonOperatorException;
import ru.trashkova.accounting.socks.exception.IncorrectSockDataException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            IncorrectSockDataException.class,
            IncorrectComparisonOperatorException.class
    })
    public ResponseEntity<ErrorDetailResponse> handleNotFoundException(Exception e) {
        return new ResponseEntity<>(
                new ErrorDetailResponse(e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}