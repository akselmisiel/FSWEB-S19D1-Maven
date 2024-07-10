package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fruit", schema = "public")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@NotNull(message = "Id is requireds")
    private Long id;
    @Column(name = "name")
    @NotNull(message = "Name is required")
    @Size(min = 2, max = 45, message = "Name must be between 1 and 45 characters")
    private String name;
    @Column(name = "price")
    @NotNull(message = "Price is required")
    @DecimalMin("10")
    private Double price;
    @Column(name = "fruit_type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Fruit type is required")
    private FruitType fruitType;
} //json for this entity is {"id":1,"name":"Apple","price":10.0,"fruitType":"FRUIT"}
