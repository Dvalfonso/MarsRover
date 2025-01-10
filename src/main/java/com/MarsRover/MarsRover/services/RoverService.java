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
            Character caracter = Character.toUpperCase(sequence.charAt(i));
            if (caracter != 'M' && caracter != 'R' && caracter != 'L') {
                throw new IllegalArgumentException("La orden " + caracter + " no existe.");
            }

            if (caracter != 'M') {
                changeDirection(caracter);
            }else {
                Output output;
                if (isInTheLimit()) {
                    changeOppositeDir(map.getRover().getDirection());
                    output = Output.builder()
                            .coordinates(map.getRover().getCoordinates())
                            .direction(map.getRover().getDirection())
                            .exit(true)
                            .build();
                    return output;
                }else {
                    if (obstacleInFront()) {
                        output = Output.builder()
                                .coordinates(map.getRover().getCoordinates())
                                .direction(map.getRover().getDirection())
                                .exit(true)
                                .build();
                        return output;
                    }
                }
                
            }

            i++;
        }

    }

    private void changeOppositeDir(Directions direction) {
        switch (direction) {
            case NORTH:
                map.getRover().setDirection(Directions.SOUTH);
                break;
            case SOUTH:
                map.getRover().setDirection(Directions.NORTH);
                break;
            case EAST:
                map.getRover().setDirection(Directions.WEST);
                break;
            case WEST:
                map.getRover().setDirection(Directions.EAST);
                break;
            default:
                System.out.println("Paso algo.");
        }
    }

    private void changeDirection(char caracter) {
        Directions actualDirection = map.getRover().getDirection();

        if (caracter == 'L') {
            switch (actualDirection) {
                case NORTH:
                    map.getRover().setDirection(Directions.WEST);
                    break;
                case SOUTH:
                    map.getRover().setDirection(Directions.EAST);
                    break;
                case EAST:
                    map.getRover().setDirection(Directions.NORTH);
                    break;
                case WEST:
                    map.getRover().setDirection(Directions.SOUTH);
                    break;
                default:
                    System.out.println("Error en el switch.");
            }
        }

        if (caracter == 'R') {
            switch (actualDirection) {
                case NORTH:
                    map.getRover().setDirection(Directions.EAST);
                    break;
                case SOUTH:
                    map.getRover().setDirection(Directions.WEST);
                    break;
                case EAST:
                    map.getRover().setDirection(Directions.SOUTH);
                    break;
                case WEST:
                    map.getRover().setDirection(Directions.NORTH);
                    break;
                default:
                    System.out.println("Error en el switch.");
            }
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

    private boolean obstacleInFront() {
        return true;
    }
}
