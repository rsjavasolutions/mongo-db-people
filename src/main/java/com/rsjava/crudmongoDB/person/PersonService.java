package com.rsjava.crudmongoDB.person;

import com.rsjava.crudmongoDB.person.exception.PersonNotFoundException;
import com.rsjava.crudmongoDB.person.mapper.PersonMapper;
import com.rsjava.crudmongoDB.person.request.PersonRequest;
import com.rsjava.crudmongoDB.person.response.PersonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

import static com.rsjava.crudmongoDB.person.mapper.PersonMapper.mapToResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Set<PersonResponse> getAllPeople() {
        return personRepository.findAll()
                .stream()
                .map(PersonMapper::mapToResponse)
                .collect(Collectors.toSet());
    }

    @Transactional
    public String savePerson(PersonRequest request) {
        log.info("Save new person.  PersonRequest {}", request);
        return personRepository.save(PersonMapper.mapToEntity(request)).getUuid();
    }

    @Transactional
    public PersonResponse getPersonByUuid(String uuid) {
        return mapToResponse(personRepository.findByUuid(uuid).orElseThrow(() -> new PersonNotFoundException(uuid)));
    }

    @Transactional
    public void deleteByUuid(String uuid) {
        personRepository.deleteByUuid(uuid);
    }

    @Transactional
    public void updatePerson(String uuid, PersonRequest request) {
        log.info("Update person.  PersonUuid {}, PersonRequest {}", uuid, request);
        PersonEntity personEntity = personRepository.findByUuid(uuid).orElseThrow(() -> new PersonNotFoundException(uuid));

        personEntity.setAge(request.getAge());
        personEntity.setName(request.getName());
        personEntity.setSurname(request.getSurname());

        personRepository.save(personEntity);
    }
}
