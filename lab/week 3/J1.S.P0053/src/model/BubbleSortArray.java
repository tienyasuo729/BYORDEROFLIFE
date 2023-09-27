package model;

import validate.Validate;

import java.util.Scanner;

public class BubbleSortArray {
    private int[] array;
    private int length;

    public void inputArray(Scanner scanner) {
        length = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the number of items in the array: ","- Length must be an integer greater than 0, please re-enter: "));

        array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(Validate.checkIntInPut("^-?[0-9]+$", "Enter element " + (i + 1) + ": ", "- Just enter the number, please re-enter: "));
        }

        System.out.println("Array input complete.");
    }

    public void sortAscending() {
        if (array != null) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        } else {
            System.out.println("Please input items of the array first.");
        }
    }

    public void sortDescending() {
        if (array != null) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        } else {
            System.out.println("Please input items of the array first.");
        }
    }

    public void displayArray() {
        if (array != null) {
            System.out.print("Sorted Array: ");
            for (int i = 0; i < length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Array is empty. Please input items of the array first.");
        }
    }
}
