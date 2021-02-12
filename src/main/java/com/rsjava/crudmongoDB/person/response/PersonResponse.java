package com.rsjava.crudmongoDB.person.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PersonResponse {
    private final String uuid;
    private final String name;
    private final String surname;
    private final Integer age;
    private final LocalDateTime creationDate;
}
