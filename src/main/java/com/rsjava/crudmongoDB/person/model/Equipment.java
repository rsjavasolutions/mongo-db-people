package com.rsjava.crudmongoDB.person.model;

import com.rsjava.crudmongoDB.person.enums.Gearbox;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    private Boolean airbag;
    private Boolean xenon;
    private Gearbox gearbox;
}
