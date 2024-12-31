package com.MarsRover.MarsRover.controllers;

import com.MarsRover.MarsRover.models.rover.Coordinates;
import com.MarsRover.MarsRover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoverController {
    @Autowired
    RoverService roverService;

    @GetMapping("/position")
    public ResponseEntity<Coordinates> getRoverPosition() {

    }

    @PostMapping("/moveRover")
    public ResponseEntity<Output> moveRover() {

    }
}
