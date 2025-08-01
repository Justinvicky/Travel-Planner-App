package com.machine.Travel.Service;

import com.machine.Travel.Entity.Travel;
import com.machine.Travel.Repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;

    public Travel createCard(Travel travel){
        return travelRepository.save(travel);
    }

    public List<Travel> getAllCard(){
        return travelRepository.findAll();
    }

    public Optional<Travel> getCardById(Long id){
        return  travelRepository.findById(id);
    }

    public Travel updateCard(Long id, Travel travelDetails) {
        Travel travel = travelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        travel.setCountry(travelDetails.getCountry());
        travel.setPlaceName(travelDetails.getPlaceName());
        travel.setBudject(travelDetails.getBudject());
        travel.setVehicle(travelDetails.getVehicle());
        return travelRepository.save(travel);
    }

    public  void deleteCard(Long id){
        travelRepository.deleteById(id);
    }
}
