package com.rsjava.crudmongoDB.person.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

    private final static String MESSAGE = "Can't find person uuid: %s";

    public PersonNotFoundException(String coverUuid) {
        super(String.format(MESSAGE, coverUuid));
        log.info(String.format(MESSAGE, coverUuid));
    }
}
