package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vegetable", schema = "public")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "Id is required")
    private Long id;
    @Column(name = "name")
    @NotNull(message = "Name is required")
    @Size(min = 2, max = 45, message = "Name must be between 1 and 45 characters")
    private String name;
    @Column(name = "price")
    @NotNull(message = "Price is required")
    @DecimalMin("10")
    private Double price;
    @Column(name = "is_grown_on_tree")
    @NotNull(message = "Is grown on tree is required")
    private boolean isGrownOnTree;


}
