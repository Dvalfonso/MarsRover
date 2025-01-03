package com.MarsRover.MarsRover.services;

import com.MarsRover.MarsRover.controllers.Output;
import com.MarsRover.MarsRover.models.map.Map;
import com.MarsRover.MarsRover.models.rover.Coordinates;
import com.MarsRover.MarsRover.models.rover.Directions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoverService {
    @Autowired
    Map map;

    Directions direction = map.getRover().getDirection();
    Coordinates coordinates = map.getRover().getCoordinates();

    public Coordinates getRoverPosition() {
        return map.getRover().getCoordinates();
    }

    public Output moveRover(String sequence) {
        int i = 0;
        while (i < sequence.length()) {
            Character caracter = sequence.charAt(i);
            if (Character.toUpperCase(caracter) != 'M' && Character.toUpperCase(caracter) != 'R' && Character.toUpperCase(caracter) != 'L') {
                throw new IllegalArgumentException("La orden " + caracter + " no existe.");
            }

            if (Character.toUpperCase(caracter) != 'M') {
                if (isInTheLimit()) {

                }
                moveIfNotObstacleInFront();
            }

            i++;
        }

    }

    private boolean isInTheLimit() {

        if (direction == Directions.NORTH && coordinates.getY() == 9) {
            return true;
        } else if (direction == Directions.SOUTH && coordinates.getY() == 0) {
            return true;
        } else if (direction == Directions.EAST && coordinates.getX() == 9) {
            return true;
        } else if (direction == Directions.WEST && coordinates.getX() == 0) {
            return true;
        }

        return false;
    }

    private void moveIfNotObstacleInFront() {

        if (direction ==  Directions.NORTH && map.getGrid().isOccupied(coordinates.getX(), coordinates.getY() + 1)) {
            System.out.println("Hay un obstaculo al norte");
            return true;
        } else if (direction ==  Directions.SOUTH && map.getGrid().isOccupied(coordinates.getX(), coordinates.getY() - 1)) {
            System.out.println("Hay un obstaculo al sur");
            return true;
        } else if (direction ==  Directions.EAST && map.getGrid().isOccupied(coordinates.getX() + 1, coordinates.getY())) {
            System.out.println("Hay un obstaculo al este");
            return true;
        } else if (direction ==  Directions.WEST && map.getGrid().isOccupied(coordinates.getX() - 1, coordinates.getY())) {
            System.out.println("Hay un obstaculo al oeste");
            return true;
        }

        return false;
    }
}
