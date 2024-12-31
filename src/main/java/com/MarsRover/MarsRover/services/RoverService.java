package com.MarsRover.MarsRover.services;

import com.MarsRover.MarsRover.controllers.Output;
import com.MarsRover.MarsRover.models.map.Map;
import com.MarsRover.MarsRover.models.rover.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoverService {
    @Autowired
    Map map;

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
            /**
             * 
             */

            i++;
        }

    }
}
