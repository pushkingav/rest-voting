package ru.restaurants.restvoting.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//  http://stackoverflow.com/a/22358422/548473
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "It's too late for vote")
public class TooLateForVoteException extends RuntimeException {
    public TooLateForVoteException(String message) {
        super(message);
    }
}
