package com.DCLink.task.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client.possibilities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientPossibilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "possibilities_id")
    private long id;

    @Column(name = "possibilities_discount_percent")
    private float discountPercent;

    @Column(name = "possibilities_discount_money")
    private float discountMoney;

    @Column(name = "possibilities_is_available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "possibilities_client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "possibilities_type_id")
    private ProductType type;

    @ManyToOne
    @JoinColumn(name = "possibilities_brand_id")
    private Brand brand;

}
