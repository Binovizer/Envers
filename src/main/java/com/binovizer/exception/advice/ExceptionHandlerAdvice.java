package com.binovizer.exception.advice;

import com.binovizer.dto.response.ApiData;
import com.binovizer.dto.response.ApiResponse;
import com.binovizer.exception.TicketServiceException;
import com.binovizer.exception.ValidationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type ExceptionHandlerAdvice
 *
 * @author Mohd Nadeem
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final String DELIMITER_COMMA = ", ";

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<?> handleValidationException(ValidationException e){
        return ApiResponse.failure(ApiData.message(e.getErrorCode().getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<String> errors = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return ApiResponse.failure(ApiData.message(String.join(DELIMITER_COMMA, errors)));
    }

    @ExceptionHandler(TicketServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<?> handleTicketServiceException(TicketServiceException e){
        return ApiResponse.failure(ApiData.message(e.getErrorCode().getMessage()));
    }

}
