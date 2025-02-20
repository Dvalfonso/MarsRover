package com.MarsRover.MarsRover.models.map;


import com.MarsRover.MarsRover.models.obstacles.Obstacle;
import com.MarsRover.MarsRover.models.rover.Coordinates;
import com.MarsRover.MarsRover.models.rover.Directions;
import com.MarsRover.MarsRover.models.rover.Rover;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class MapRover {
    private Grid grid;
    private Rover rover;
    private List<Obstacle> obstacleList;

    @Autowired
    public MapRover(Grid grid, Rover rover) {
        this.grid = grid;
        this.rover = rover;
        grid.mark(rover.getCoordinates().getX(), rover.getCoordinates().getY());
        obstacleList = new ArrayList<>();
    }
}
