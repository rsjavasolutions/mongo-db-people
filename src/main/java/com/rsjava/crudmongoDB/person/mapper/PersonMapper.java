package com.rsjava.crudmongoDB.person.mapper;

import com.rsjava.crudmongoDB.person.PersonEntity;
import com.rsjava.crudmongoDB.person.request.PersonRequest;
import com.rsjava.crudmongoDB.person.response.PersonResponse;

public class PersonMapper {

    public static PersonEntity mapToEntity(PersonRequest request) {
        return new PersonEntity(
                request.getName(),
                request.getSurname(),
                request.getAge(),
                request.getCars()
        );
    }

    public static PersonResponse mapToResponse(PersonEntity entity) {
        return new PersonResponse(
                entity.getUuid(),
                entity.getName(),
                entity.getSurname(),
                entity.getAge(),
                entity.getCreationDate(),
                entity.getCars()
        );
    }
}
