package com.aggregrator.ambulanceservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AddressDTO {
    private String province;
    private String city;
    private String address;
}
