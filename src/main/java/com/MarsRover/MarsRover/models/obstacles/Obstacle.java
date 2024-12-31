package com.MarsRover.MarsRover.models.obstacles;

import com.MarsRover.MarsRover.models.rover.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Obstacle {
    private Coordinates coordinates;
}
