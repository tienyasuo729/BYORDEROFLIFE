package model;

import java.util.Random;

public class LinearSearch {
    private int[] array;

    public LinearSearch(int size) {
        array = new int[size];
    }

    public void generateRandomArray(int range) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range + 1);
        }
    }

    public int linearSearch(int searchNumber) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNumber) {
                return i; // Return the index if the search number is found
            }
        }
        return -1; // Return -1 if the search number is not found
    }

    public void displayArray() {
        System.out.println("Generated array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
