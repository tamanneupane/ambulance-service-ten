package com.aggregrator.ambulanceservice.repository;

import com.aggregrator.ambulanceservice.model.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AmbulanceRepository extends CrudRepository<Ambulance, Long> {
}
