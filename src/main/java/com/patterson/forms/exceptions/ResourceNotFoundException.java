package com.patterson.forms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long idRecurse) {
        super(String.format("%s was not found", idRecurse));
    }

    public ResourceNotFoundException(String stringRecurse) {
        super(String.format("%s was not found", stringRecurse));
    }

}
