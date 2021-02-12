package com.rsjava.crudmongoDB.person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<PersonEntity, String> {

    Optional<PersonEntity> findByUuid(String uuid);

    void deleteByUuid(String uuid);

}
