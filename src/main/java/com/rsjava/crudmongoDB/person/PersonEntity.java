package com.rsjava.crudmongoDB.person;

import com.rsjava.crudmongoDB.person.model.Car;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "people")
public class PersonEntity {
    @Id
    private String id;
    @Setter(AccessLevel.NONE)
    private String uuid;
    private String name;
    private String surname;
    private Integer age;
    @Setter(AccessLevel.NONE)
    private LocalDateTime creationDate;
    private Set<Car> cars;

    public PersonEntity(String name,
                        String surname,
                        Integer age,
                        Set<Car> cars) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.creationDate = LocalDateTime.now();
        this.cars = cars;
    }
}


