package com.aggregrator.ambulanceservice.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Table
@Entity(name = "address_tbl")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String province;
    private String city;
    private String address;

    @OneToOne(mappedBy = "address")
    private Ambulance ambulance;
}
