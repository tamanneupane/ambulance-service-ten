package com.aggregrator.ambulanceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v2")
public class AmbulanceAPIControllerV2 {

    @PostMapping(value = "")
    public String ping(){
        return "Ambulance Service is working fine in V2";
    }

    @GetMapping(value = "/ambulance")
    public String ambulanceList(){
        return "This is list of ambulance of V2";
    }

}
