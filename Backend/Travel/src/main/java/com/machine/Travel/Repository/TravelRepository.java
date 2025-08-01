package com.machine.Travel.Repository;

import com.machine.Travel.Entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}
