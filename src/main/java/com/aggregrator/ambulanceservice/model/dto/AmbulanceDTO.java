package com.aggregrator.ambulanceservice.model.dto;

import com.aggregrator.ambulanceservice.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AmbulanceDTO {
    private String name;
    private List<String> phones;
    private double lat;
    private double lon;
    private AddressDTO address;
    private boolean open;
}
