package com.MarsRover.MarsRover.models.rover;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 */
@Data
@AllArgsConstructor
public class Rover {
    private Integer x;
    private Integer y;
    private Directions direction;
}
