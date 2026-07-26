package com.example.demo.exception;

import com.example.demo.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// spring이 발생한 예외를 들고 경찰서에 와서 @ExceptionHandler를 보고 담당자에게 예외 전달한다
@RestControllerAdvice
public class GlobalExceptionHandler {

    //@뒤에는 타입이 아니라 값이 들어가야하기 때문에 .class가 붙는다...
    @ExceptionHandler(SharkNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleSharkNotFound(SharkNotFoundException e){
        return new ErrorResponse(
                404,
                e.getMessage()
        );
    }

    // ResponseEntity는 spring이 제공하는 포장 상자 (http 상태 코드 + 헤더 + 본문(JSON))
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>
    handleValidationException(MethodArgumentNotValidException ex){
        String message =
                ex.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage();

        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        400, message
                )
        );
    }
}
    