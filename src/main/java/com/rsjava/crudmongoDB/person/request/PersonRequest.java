package com.rsjava.crudmongoDB.person.request;

import com.rsjava.crudmongoDB.person.model.Car;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Car> cars = new HashSet<>();
}
