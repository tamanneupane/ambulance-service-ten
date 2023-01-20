package com.aggregrator.ambulanceservice.service;

import com.aggregrator.ambulanceservice.model.Address;
import com.aggregrator.ambulanceservice.model.Ambulance;
import com.aggregrator.ambulanceservice.model.dto.AddressDTO;
import com.aggregrator.ambulanceservice.model.dto.AmbulanceDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AmbulanceService {

    public List<Ambulance> getAmbulanceList(){
        return new ArrayList<>();
    }

    public Optional<Ambulance> getAmbulanceDetail(String ambulanceId){
        List<String> phones = List.of("01-444567","01-444789");
        Address address = new Address("Bagmati", "Lalitpur","Jawlakhel");
        Ambulance ambulance =  new Ambulance(UUID.randomUUID().toString(),"Alka Hospital",phones, 27.82, 85.27, address, true, LocalDateTime.now());
        return Optional.of(ambulance);
    }

    public Ambulance createAmbulance(AmbulanceDTO ambulanceDTO){
        AddressDTO addressDTO = ambulanceDTO.getAddress();
        Address address = new Address(addressDTO.getProvince(),addressDTO.getCity(), addressDTO.getAddress());
        return new Ambulance(UUID.randomUUID().toString(),ambulanceDTO.getName(),ambulanceDTO.getPhones(), ambulanceDTO.getLat(), ambulanceDTO.getLon(), address, ambulanceDTO.isOpen(), LocalDateTime.now());
    }

    public Ambulance updateAmbulance(String ambulanceId ,AmbulanceDTO ambulanceDTO){
        AddressDTO addressDTO = ambulanceDTO.getAddress();
        Address address = new Address(addressDTO.getProvince(),addressDTO.getCity(), addressDTO.getAddress());
        return new Ambulance(UUID.randomUUID().toString(),ambulanceDTO.getName(),ambulanceDTO.getPhones(), ambulanceDTO.getLat(), ambulanceDTO.getLon(), address, ambulanceDTO.isOpen(), LocalDateTime.now());
    }

    public void deleteAmbulance(String ambulanceId){

    }
}
