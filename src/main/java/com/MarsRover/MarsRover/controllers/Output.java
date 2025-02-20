package com.MarsRover.MarsRover.controllers;

import com.MarsRover.MarsRover.models.rover.Coordinates;
import com.MarsRover.MarsRover.models.rover.Directions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Output {
    private boolean exit;
    private Coordinates coordinates;
    private Directions direction;
}
