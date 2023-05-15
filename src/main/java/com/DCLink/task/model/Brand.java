package com.DCLink.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brand")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Brand {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "brand_id")
    private int id;


    @Column(name = "brand_name")
    private String name;

}
