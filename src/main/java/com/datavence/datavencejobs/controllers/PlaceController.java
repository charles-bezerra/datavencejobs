package com.datavence.datavencejobs.controllers;

import com.datavence.datavencejobs.models.Place;
import com.datavence.datavencejobs.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("")
    public @ResponseBody List<Place> getAllPlaces () {
        return placeRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Place> getPlace (@PathVariable(name = "id") Long id) {
        return placeRepository.findById(id);
    }

    @PostMapping("")
    public @ResponseBody Place postPlace (@RequestBody Place place) {
        return placeRepository.save(place);
    }

    @DeleteMapping("")
    public void deletePlace (@RequestBody Place place){
        placeRepository.delete(place);
    }

    @PutMapping("")
    public @ResponseBody Place putPlace (@RequestBody Place place) {
        return placeRepository.save(place);
    }
}
