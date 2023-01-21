package com.aggregrator.ambulanceservice.model.dto;

import com.aggregrator.ambulanceservice.validations.NotEmptyCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AmbulanceDTO {

    @NotNull(message = "The name of the ambulance provider cannot be null")
    @NotEmpty
    private String name;

    @NotEmpty
    private List<String> phones;

    private double lat;
    private double lon;
    private AddressDTO address;
    private boolean open;
}
