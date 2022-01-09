package ru.bellintegrator.practice.exception;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Обработчик ошибок в контроллерах
 */
@RestControllerAdvice
public class ExceptionHandlerController{
    private final Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler({Exception.class})
    protected @ResponseBody ResponseEntity<?> handleException1(Exception e) {
        Integer number =e.hashCode();

        ErrorDto errorDto = new ErrorDto("№ " + number);
        log.error("Error № " + number + ": " + e.getMessage(), e.getCause());
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

