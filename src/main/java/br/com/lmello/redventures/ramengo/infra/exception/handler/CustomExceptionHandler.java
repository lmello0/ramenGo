package br.com.lmello.redventures.ramengo.infra.exception.handler;

import br.com.lmello.redventures.ramengo.dto.ErrorResponseDTO;
import br.com.lmello.redventures.ramengo.infra.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException e) {
        ErrorResponseDTO error = new ErrorResponseDTO(e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();

        return ResponseEntity.badRequest().body(
                fieldErrors
                        .stream()
                        .map(DataValidationError::new)
                        .toList()
        );
    }

    private record DataValidationError(String field, String message) {
        public DataValidationError(FieldError e) {
            this(e.getField(), e.getDefaultMessage());
        }
    }
}