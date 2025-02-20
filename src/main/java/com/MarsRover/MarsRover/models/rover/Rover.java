package com.MarsRover.MarsRover.models.rover;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 */
@Data
@Component
public class Rover {
    private Coordinates coordinates;
    private Directions direction;

    public Rover() {
        this.coordinates = new Coordinates();
        coordinates.setY(0);
        coordinates.setX(0);
        direction = Directions.NORTH;
    }
}
