package com.enterprise.facebook.lintcode;

/**
 * Description
 * Given a 2D matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class Code665_RangeSumQuery2DImmutable {
    private int[][] newMatrix;
    public Code665_RangeSumQuery2DImmutable(int[][] matrix) {
        this.newMatrix = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++){
                if (i == 0 && j == 0) {
                    newMatrix[i][j] = matrix[i][j];
                }
                else if (i == 0) {
                    newMatrix[i][j] += matrix[i][j-1];
                }
                else if (j == 0) {
                    newMatrix[i][j] += matrix[j][i-1];
                }
                else {
                    newMatrix[i][j] += matrix[i][j-1] + matrix[i-1][j] - matrix[i-1][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return newMatrix[row2][col2];
        }

        if (row1 == 0) {
            return newMatrix[row2][col2] - newMatrix[row2][col1 - 1];
        }

        if (col1 == 0) {
            return newMatrix[row2][col2] - newMatrix[row1 - 1][col2];
        }

        return newMatrix[row2][col2] - newMatrix[row2][col1 - 1] - newMatrix[row1-1][col2]+newMatrix[row1-1][col1-1];
    }
}
