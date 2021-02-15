package com.rsjava.crudmongoDB.person;

import com.rsjava.crudmongoDB.aop.EmailSender;
import com.rsjava.crudmongoDB.person.request.PersonRequest;
import com.rsjava.crudmongoDB.person.response.PersonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @EmailSender
    public Set<PersonResponse> getAllPeople() {
        return personService.getAllPeople();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPerson(@RequestBody PersonRequest request) {
        return personService.savePerson(request);
    }

    @GetMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse getPersonByUuid(@PathVariable String uuid) {
        return personService.getPersonByUuid(uuid);
    }

    @DeleteMapping("{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonByUuid(@PathVariable String uuid) {
        personService.deleteByUuid(uuid);
    }

    @PutMapping("{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePerson(@PathVariable String uuid,
                             @RequestBody PersonRequest request) {
        personService.updatePerson(uuid, request);
    }
}
