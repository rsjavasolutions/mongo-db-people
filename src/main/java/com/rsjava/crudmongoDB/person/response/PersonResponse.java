package com.rsjava.crudmongoDB.person.response;

import com.rsjava.crudmongoDB.person.model.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
public class PersonResponse {
    private final String uuid;
    private final String name;
    private final String surname;
    private final Integer age;
    private final LocalDateTime creationDate;
    private final Set<Car> cars;
}
