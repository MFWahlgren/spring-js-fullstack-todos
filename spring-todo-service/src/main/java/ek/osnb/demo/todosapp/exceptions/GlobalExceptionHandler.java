package ek.osnb.demo.todosapp.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException ex) {
        ProblemDetail pd = ProblemDetail.forStatus(404);
        pd.setTitle("Resource Not Found");
        pd.setDetail(ex.getMessage());
        return pd;
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ProblemDetail handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        ProblemDetail pd = ProblemDetail.forStatus(409);
        pd.setTitle("Resource Already Exists");
        pd.setDetail(ex.getMessage());
        return pd;
    }
}
