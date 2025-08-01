package com.machine.Travel.Controller;
import  java.util.List;

import com.machine.Travel.Entity.Travel;
import com.machine.Travel.Service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel")
@CrossOrigin(origins = "http://localhost:3000") // example: allow React app on localhost:3000
public class TravelController {

    @Autowired
    private TravelService travelService;

@PostMapping
    public Travel createCard(@RequestBody Travel travel){
    return travelService.createCard(travel);
}

@GetMapping
    public  List<Travel> getAllCard(){
    return travelService.getAllCard();
}
@GetMapping("/{id}")
    public Travel getCardById(@PathVariable Long id){
return travelService.getCardById(id).orElse(null);
}
@PutMapping("/{id}")
    public Travel updateCard(@PathVariable Long id, @RequestBody Travel travel){
return travelService.updateCard(id, travel);
}

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Long id) {
        travelService.deleteCard(id);
        return "Card deleted with ID : " + id;
    }


}
