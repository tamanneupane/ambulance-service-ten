package com.aggregrator.ambulanceservice.controller;

import com.aggregrator.ambulanceservice.model.Address;
import com.aggregrator.ambulanceservice.model.Ambulance;
import com.aggregrator.ambulanceservice.model.dto.AddressDTO;
import com.aggregrator.ambulanceservice.model.dto.AmbulanceDTO;
import com.aggregrator.ambulanceservice.service.AmbulanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class AmbulanceAPIControllerV1 {

    @PostMapping(value = "")
    public String ping(){
        return "Ambulance Service is working fine in V1";
    }

    @GetMapping(value = "/ambulance/list")
    public ResponseEntity<List<Ambulance>> ambulanceList(@RequestParam(value = "city", required = false) String cityName, @RequestParam(value = "lat", required = false) Double lat,@RequestParam(value = "lon", required = false)  Double lon){
        AmbulanceService ambulanceService = new AmbulanceService();
        List<Ambulance> ambulanceList = ambulanceService.getAmbulanceList();
        return ResponseEntity.status(HttpStatus.OK).body(ambulanceList);
    }

    @GetMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> getAmbulanceDetail(@PathVariable(value = "id") String ambulanceId){
        AmbulanceService ambulanceService = new AmbulanceService();
        Optional<Ambulance> optAmbulance = ambulanceService.getAmbulanceDetail(ambulanceId);
        return optAmbulance.map(ambulance -> ResponseEntity.status(HttpStatus.OK).body(ambulance)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "/ambulance")
    public ResponseEntity<Ambulance> createAmbulance(@RequestBody AmbulanceDTO ambulanceDTO){
        System.out.println(ambulanceDTO);
        AmbulanceService ambulanceService = new AmbulanceService();
        Ambulance createdAmbulance =  ambulanceService.createAmbulance(ambulanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAmbulance);
    }

    @PutMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable(value = "id") String ambulanceID, @RequestBody AmbulanceDTO ambulanceDTO){
        AmbulanceService ambulanceService = new AmbulanceService();
        Ambulance updatedAmbulance =  ambulanceService.updateAmbulance(ambulanceID,ambulanceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAmbulance);
    }

    @DeleteMapping(value = "/ambulance/{id}")
    public ResponseEntity<String> deleteAmbulance(@PathVariable(value = "id") String ambulanceID){
        System.out.println(ambulanceID);
        AmbulanceService ambulanceService = new AmbulanceService();
        ambulanceService.deleteAmbulance(ambulanceID);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*
        {
            "name" : "Alka Hospital",
            "phone" : "01-4444567",
            "lat" : 27.89,
            "lon" : 85.23
        }
     */

    /*
    <ambulances>
        <ambulance>
            <name>Alka Hospital</name>
            <phone>01-4444567</phone>
            <lat>27.89</lat>
            <lon>85.23</lon>
        </ambulance>
        <ambulance>
            <name>Alka Hospital 2</name>
            <phone>01-4444567</phone>
            <lat>27.89</lat>
            <lon>85.23</lon>
        </ambulance>
    </ambulances>

     */

}
