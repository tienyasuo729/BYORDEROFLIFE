package model;

import validate.Validate;

import java.util.Scanner;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public void inputMatrix(Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$", "Enter the value for element (" + (i + 1) + ", " + (j + 1) + "): ", "- Values of matrix must be numbers, please enter again: "));
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" +data[i][j] + "]" + "\t");
            }
            System.out.println();
        }
    }

    public Matrix addMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            System.out.println("Matrix dimensions must be the same for addition.");
            return null;
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + matrix2.data[i][j];
            }
        }

        return result;
    }

    public Matrix subtractMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            System.out.println("Matrix dimensions must be the same for subtraction.");
            return null;
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - matrix2.data[i][j];
            }
        }

        return result;
    }

    public Matrix multiplyMatrix(Matrix matrix2) {
        if (this.cols != matrix2.rows) {
            System.out.println("Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return null;
        }

        Matrix result = new Matrix(this.rows, matrix2.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix2.cols; j++) {
                double dotProduct = 0;
                for (int k = 0; k < this.cols; k++) {
                    dotProduct += this.data[i][k] * matrix2.data[k][j];
                }
                result.data[i][j] = dotProduct;
            }
        }

        return result;
    }

    public void displayMatrixWithOperation(String operation, Matrix matrix2, Matrix result) {
        System.out.println("Matrix 1:");
        displayMatrix();
        System.out.println(operation);
        System.out.println("Matrix 2:");
        matrix2.displayMatrix();
        System.out.println("Result:");
        result.displayMatrix();
    }
}
