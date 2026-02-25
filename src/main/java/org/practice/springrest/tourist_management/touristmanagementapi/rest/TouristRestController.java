package org.practice.springrest.tourist_management.touristmanagementapi.rest;

import org.practice.touristmanagementapi.model.Tourist;
import org.practice.touristmanagementapi.service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Primary logic call; secondary logic (exception handling) is managed globally
@RestController
@RequestMapping("/api/tourist")
public class TouristRestController {

    @Autowired
    private ITouristService service;

    @PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
        String message = service.registerTourist(tourist);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> displayTourists() {
        List<Tourist> list = service.fetchAllTouristInfo();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
        Tourist tourist = service.fetchTouristById(id);
        return new ResponseEntity<>(tourist, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {
        String msg = service.updateTourist(tourist);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/budgetUpdate/{id}/{budget}")
    public ResponseEntity<String> updateBudget(@PathVariable Integer id, @PathVariable Integer budget) {
        String msg = service.updateTouristBudget(id, budget);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeTourist(@PathVariable("id") Integer id) {
        String message = service.deleteTourist(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}