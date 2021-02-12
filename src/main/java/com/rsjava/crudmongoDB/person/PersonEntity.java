package com.rsjava.crudmongoDB.person;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "people")
public class PersonEntity {
    @Id
    private String id;
    private String uuid;
    private String name;
    private String surname;
    private Integer age;
    @Setter(AccessLevel.NONE)
    private LocalDateTime creationDate;

    public PersonEntity(String name, String surname, Integer age) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.creationDate = LocalDateTime.now();
    }
}


