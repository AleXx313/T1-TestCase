package t1_testcase.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ErrorResponse handleConstraintValidationException(final ConstraintViolationException e){
        return new ErrorResponse("Входящие значения не соответствуют заданному формату!", e.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException e){
        return new ErrorResponse("Входящие значения недопустимы!", e.getMessage());
    }

    @ExceptionHandler({Throwable.class})
    public ErrorResponse handleNotSpecifiedException(final Throwable e){
        return new ErrorResponse("Входящие значения недопустимы!", e.getMessage());
    }
}
