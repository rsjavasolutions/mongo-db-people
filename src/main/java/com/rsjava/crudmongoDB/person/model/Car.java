package com.rsjava.crudmongoDB.person.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private String model;
    private BigDecimal price;
    private Set<Equipment> equipments = new HashSet<>();
}
