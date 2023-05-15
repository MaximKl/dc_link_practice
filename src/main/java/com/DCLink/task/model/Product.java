package com.DCLink.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name ="product_cost")
    private float cost;

    @Column(name ="product_price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType type;

    @ManyToOne
    @JoinColumn(name = "product_brand_id")
    private Brand brand;

    @Column(name ="product_is_available")
    private boolean productIsAvailable;

    @Column(name ="product_name")
    private String productName;

    @Column(name ="product_description")
    private String productDescription;
}
