package com.aggregrator.ambulanceservice.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Ambulance {
    private String id;
    private String name;
    private List<String> phones;
    private double lat;
    private double lon;
    private Address address;
    private boolean isOpened;
    private LocalDateTime createdOn;
}
