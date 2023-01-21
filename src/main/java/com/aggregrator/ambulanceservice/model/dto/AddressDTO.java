package com.aggregrator.ambulanceservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@ToString
public class AddressDTO {
    @NotNull
    @NotEmpty
    private String province;
    private String city;
    private String address;
}
