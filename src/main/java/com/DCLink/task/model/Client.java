package com.DCLink.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private long id;
    @Column(name="client_name")
    private String name;
    @Column(name="client_surname")
    private String surname;
    @Column(name="client_patronymic_name")
    private String patronymicName;
    @Column(name="client_bussiness_name")
    private String businessName;
    @Column(name="client_base_discount")
    private float baseDiscount;
    @Column(name="client_is_cooperate")
    private boolean isCooperating;

}
