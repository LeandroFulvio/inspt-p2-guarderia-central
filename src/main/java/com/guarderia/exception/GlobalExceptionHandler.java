package com.guarderia.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@ControllerAdvice
@Controller
public class GlobalExceptionHandler implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // API error handler
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        if (isApiRequest(request)) {
            logger.error("Entity not found", e);
            ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        // Handle frontend error
        return handleErrorPage(HttpStatus.NOT_FOUND, e.getMessage(), request);
    }

    // Generic error handler para frontend
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        model.addAttribute("statusCode", status != null ? status.toString() : "500");
        model.addAttribute("errorMessage", message != null ? message : "An error occurred");

        return "error/error";  // This will render your error.html template
    }

    // Helper para determinar si el request es para la api
    private boolean isApiRequest(HttpServletRequest request) {
        String acceptHeader = request.getHeader("Accept");
        return acceptHeader != null && acceptHeader.contains("application/json");
    }

    private ResponseEntity<String> handleErrorPage(HttpStatus status, String message, HttpServletRequest request) {
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, status.value());
        request.setAttribute(RequestDispatcher.ERROR_MESSAGE, message);
        return ResponseEntity.status(status).body("error");
    }

}
