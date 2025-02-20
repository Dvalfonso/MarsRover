package com.MarsRover.MarsRover.models.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  Un true en la matriz representa un obstaculo
 */
@Component
public class Grid {
    private boolean[][] matrix;
    private MatrixUtil matrixUtil;

    @Autowired
    public Grid(MatrixUtil matrixUtil) {
        int size = matrixUtil.getMatrixSize();
        matrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = false;
            }
        }
    }

    public boolean isOccupied(int x, int y){
        return matrix[x][y];
    }

    public void mark(int x, int y){
        matrix[x][y] = true;
    }

    public void remove(int x, int y) {
        matrix[x][y] = false;
    }
}
