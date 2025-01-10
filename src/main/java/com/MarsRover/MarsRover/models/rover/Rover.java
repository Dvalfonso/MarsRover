package com.MarsRover.MarsRover.models.rover;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rover {
    private Coordinates coordinates;
    private Directions direction;
}
