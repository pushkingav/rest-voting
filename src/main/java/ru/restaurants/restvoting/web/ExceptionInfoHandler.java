package ru.restaurants.restvoting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.restaurants.restvoting.util.ValidationUtil;
import ru.restaurants.restvoting.util.exception.ErrorInfo;
import ru.restaurants.restvoting.util.exception.ErrorType;
import ru.restaurants.restvoting.util.exception.NotFoundException;
import ru.restaurants.restvoting.util.exception.TooLateForVoteException;

import javax.servlet.http.HttpServletRequest;

import static ru.restaurants.restvoting.util.exception.ErrorType.DATA_NOT_FOUND;
import static ru.restaurants.restvoting.util.exception.ErrorType.VALIDATION_ERROR;

@RestControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE + 5)
public class ExceptionInfoHandler {
    private static Logger log = LoggerFactory.getLogger(ExceptionInfoHandler.class);

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(NotFoundException.class)
    public ErrorInfo handleError(HttpServletRequest req, NotFoundException e) {
        return logAndGetErrorInfo(req, e, true, DATA_NOT_FOUND);
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(TooLateForVoteException.class)
    public ErrorInfo handleTooLateForVoteError(HttpServletRequest req, TooLateForVoteException e) {
        return new ErrorInfo(req.getRequestURL(), VALIDATION_ERROR, ValidationUtil.getMessage(ValidationUtil.getRootCause(e)));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorInfo validateJsonErrors(HttpServletRequest req, Exception e) {
        return logAndGetErrorInfo(req, e, true, VALIDATION_ERROR);
    }

    //https://stackoverflow.com/questions/538870/should-private-helper-methods-be-static-if-they-can-be-static
    private static ErrorInfo logAndGetErrorInfo(HttpServletRequest req, Exception e, boolean logException, ErrorType errorType) {
        Throwable rootCause = ValidationUtil.getRootCause(e);
        if (logException) {
            log.error(errorType + " at request " + req.getRequestURL(), rootCause);
        } else {
            log.warn("{} at request  {}: {}", errorType, req.getRequestURL(), rootCause.toString());
        }
        return new ErrorInfo(req.getRequestURL(), errorType, ValidationUtil.getMessage(rootCause));
    }

}
