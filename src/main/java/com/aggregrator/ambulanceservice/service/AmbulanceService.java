package com.aggregrator.ambulanceservice.service;

import com.aggregrator.ambulanceservice.model.Address;
import com.aggregrator.ambulanceservice.model.Ambulance;
import com.aggregrator.ambulanceservice.model.dto.AddressDTO;
import com.aggregrator.ambulanceservice.model.dto.AmbulanceDTO;
import com.aggregrator.ambulanceservice.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AmbulanceService {

    @Autowired
    AmbulanceRepository ambulanceRepository;

    public Iterable<Ambulance> getAmbulanceList(){
        return ambulanceRepository.findAll();
    }

    public Optional<Ambulance> getAmbulanceDetail(Long ambulanceId){
        List<String> phones = List.of("01-444567","01-444789");
        Address address = new Address("Bagmati", "Lalitpur","Jawlakhel");
        Ambulance ambulance =  new Ambulance("Alka Hospital", 27.82, 85.27, true, LocalDateTime.now());
        return Optional.of(ambulance);
    }

    public Ambulance createAmbulance(AmbulanceDTO ambulanceDTO){
        AddressDTO addressDTO = ambulanceDTO.getAddress();
        Address address = new Address(addressDTO.getProvince(),addressDTO.getCity(), addressDTO.getAddress());
        Ambulance ambulance = new Ambulance(ambulanceDTO.getName(), ambulanceDTO.getLat(), ambulanceDTO.getLon(), ambulanceDTO.isOpen(), LocalDateTime.now());
        return ambulanceRepository.save(ambulance);
    }

    public Ambulance updateAmbulance(Long ambulanceId ,AmbulanceDTO ambulanceDTO){

        Optional<Ambulance> optionalAmbulance = ambulanceRepository.findById(ambulanceId);

        if(optionalAmbulance.isPresent()){
            // Code to update
            Ambulance ambulanceToUpdate = optionalAmbulance.get();
            ambulanceToUpdate.setName(ambulanceDTO.getName());
            ambulanceToUpdate.setLon(ambulanceDTO.getLon());
            ambulanceToUpdate.setLat(ambulanceDTO.getLat());
            ambulanceToUpdate.setOpened(ambulanceDTO.isOpen());

           return ambulanceRepository.save(ambulanceToUpdate);
        }else{
            throw new RuntimeException(String.format("The ambulance with the id %d is not present", ambulanceId));
        }

//        AddressDTO addressDTO = ambulanceDTO.getAddress();
//        Address address = new Address(addressDTO.getProvince(),addressDTO.getCity(), addressDTO.getAddress());
//        return new Ambulance(ambulanceDTO.getName(), ambulanceDTO.getLat(), ambulanceDTO.getLon(), ambulanceDTO.isOpen(), LocalDateTime.now());
    }

    public void deleteAmbulance(Long ambulanceId){
        ambulanceRepository.deleteById(ambulanceId);
    }
}
