package co.unicauca.parcial.exceptionControllers;

import co.unicauca.parcial.exceptionControllers.exceptions.*;
import co.unicauca.parcial.exceptionControllers.exceptions.Error;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(fieldName+ " : " + errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Peticion erronea: " + e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final EntityExistsException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.ENTITY_EXIST.getCode(),
                        String.format("%s, %s", ErrorCode.ENTITY_EXIST.getMessageKey(),
                                ex.getMessage()),
                        HttpStatus.NOT_ACCEPTABLE.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final BusinessRuleException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.BUSINESS_RULE_VIOLATION.getCode(), ex.formatException(),
                        HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotExistsException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final EntityNotExistsException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.ENTITY_NOT_EXIST.getCode(),
                        String.format("%s, %s",
                                ErrorCode.ENTITY_NOT_EXIST.getMessageKey(),
                                ex.getMessage()),
                        HttpStatus.NOT_FOUND.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StorageErrorDBException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final StorageErrorDBException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.STORAGE_DB_VIOLATION.getCode(),
                        String.format("%s, %s",
                                ErrorCode.STORAGE_DB_VIOLATION.getMessageKey(),
                                ex.getMessage()),
                        HttpStatus.NOT_ACCEPTABLE.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
}
