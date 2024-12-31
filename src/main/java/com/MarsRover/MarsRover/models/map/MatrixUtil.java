package com.MarsRover.MarsRover.models.map;

import org.springframework.stereotype.Component;

@Component
public class MatrixUtil {
    private final int MATRIX_SIZE = 10;

    public int getMatrixSize() {
        return MATRIX_SIZE;
    }
}

