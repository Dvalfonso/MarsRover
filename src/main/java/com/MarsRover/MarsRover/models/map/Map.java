package com.MarsRover.MarsRover.models.map;


import com.MarsRover.MarsRover.models.rover.Coordinates;
import com.MarsRover.MarsRover.models.rover.Directions;
import com.MarsRover.MarsRover.models.rover.Rover;

import java.util.List;

public class Map {
    private Grid grid;
    private Rover rover;
    private List<Obstacle> obstacleList;

    public Map() {
        grid = new Grid();
        rover = new Rover(new Coordinates(0,0), Directions.NORTH);
        grid.mark(rover.getCoordinates().getX(), rover.getCoordinates().getX());
    }
}
