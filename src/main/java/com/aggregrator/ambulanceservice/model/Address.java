package com.aggregrator.ambulanceservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class Address {
    private String province;
    private String city;
    private String address;
}
