package com.MarsRover.MarsRover.models.map;

import org.springframework.beans.factory.annotation.Autowired;

public class Grid {
    private boolean[][] matrix;
    private final Integer DEFAULT_CAPACITY = 5;

    @Autowired
    MatrixUtil matrixUtil;

    public Grid() {
        int size = matrixUtil.getMatrixSize();
        matrix = new boolean[size][size];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            for (int j = 0; j < DEFAULT_CAPACITY; j++) {
                matrix[i][j] = false;
            }
        }
    }

    public boolean isOccupied(int x, int y){
        return matrix[x][y] = true;
    }
}
