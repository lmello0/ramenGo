package br.com.lmello.redventures.ramengo.infra.exception.handler;

import br.com.lmello.redventures.ramengo.dto.ErrorResponseDTO;
import br.com.lmello.redventures.ramengo.infra.exception.InvalidRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@ControllerAdvice(value = "br.com.lmello.redventures.ramengo.controller.OrderController", annotations = RestController.class)
@RequiredArgsConstructor
public class OrderControllerExceptionHandler {

    private final Logger logger = Logger.getLogger(OrderControllerExceptionHandler.class.getName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
        logger.severe(e.getMessage());
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("could not place order"));
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, InvalidRequestException.class })
    public ResponseEntity<?> handleMethodArgumentNotValidException() {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO("both brothId and proteinId are required"));
    }
}
