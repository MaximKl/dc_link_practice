package com.DCLink.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product.type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductType {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_type_id")
    private int id;


    @Column(name = "product_type_name")
    private String name;

}
