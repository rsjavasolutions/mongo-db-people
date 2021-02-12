package com.rsjava.crudmongoDB.person.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotNull
    private Integer age;
}
