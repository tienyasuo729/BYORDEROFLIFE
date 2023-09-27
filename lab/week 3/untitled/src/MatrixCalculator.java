import model.Matrix;
import validate.Validate;

import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== CALCULATOR PROGRAM =====");
            System.out.println("1. Addition of Matrices");
            System.out.println("2. Subtraction of Matrices");
            System.out.println("3. Multiplication of Matrices");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(Validate.checkIntInPut("^[1-4]$","- Enter your choice (1/2/3/4): ","- Invalid choice. Please select a valid option (1/2/3/4): "));

            if (choice == 1 || choice == 2 || choice == 3) {
                int rows1 = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the number of rows for the first matrix: ","- Only enter positive integers, please re-enter: "));
                int cols1 = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the number of columns for the first matrix: ","- Only enter positive integers, please re-enter: "));
                int rows2 = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the number of rows for the second matrix: ","- Only enter positive integers, please re-enter: "));
                int cols2 = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the number of columns for the second matrix: ","- Only enter positive integers, please re-enter: "));


                if ((choice == 1 || choice == 2) && (rows1 != rows2 || cols1 != cols2)) {
                    System.out.println("Matrix dimensions must be the same for addition or subtraction.");
                    continue;
                } else if (choice == 3 && cols1 != rows2) {
                    System.out.println("Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
                    continue;
                }

                Matrix matrix1 = new Matrix(rows1, cols1);
                Matrix matrix2 = new Matrix(rows2, cols2);

                System.out.println("Enter values for the first matrix:");
                matrix1.inputMatrix(scanner);

                System.out.println("Enter values for the second matrix:");
                matrix2.inputMatrix(scanner);

                Matrix result = null;
                String operation = "";

                if (choice == 1) {
                    result = matrix1.addMatrix(matrix2);
                    operation = " + ";
                } else if (choice == 2) {
                    result = matrix1.subtractMatrix(matrix2);
                    operation = " - ";
                } else {
                    result = matrix1.multiplyMatrix(matrix2);
                    operation = " * ";
                }

                if (result != null) {
                    System.out.println("\nResult:");
                    result.displayMatrixWithOperation(operation, matrix2, result);
                }
            } else if (choice == 4) {
                System.exit(0);
            }
        }
    }
}