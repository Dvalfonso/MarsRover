package com.MarsRover.MarsRover.controllers;

import com.MarsRover.MarsRover.models.map.MapRover;
import com.MarsRover.MarsRover.models.rover.Coordinates;
import com.MarsRover.MarsRover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoverController {

    private final RoverService roverService;

    @Autowired
    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    @GetMapping("/position")
    public ResponseEntity<Coordinates> getRoverPosition() {
        return ResponseEntity.ok(roverService.getRoverPosition());
    }

    @PostMapping("/moveRover")
    public ResponseEntity<Output> moveRover(@RequestBody MoveRequest request) {
        return ResponseEntity.ok(roverService.moveRover(request.getSequence()));
    }
}
