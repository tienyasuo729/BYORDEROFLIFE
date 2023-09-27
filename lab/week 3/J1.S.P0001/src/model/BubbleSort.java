package model;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    private int[] array;

    public BubbleSort(int size) {
        array = new int[size];
    }

    public void generateRandomArray(int maxRange) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxRange + 1);
        }
    }

    public void sort() {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    // Swap the elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                // If no two elements were swapped in inner loop, the array is already sorted
                break;
            }
        }
    }

    public void displayArray() {
        System.out.println("Array Elements:");
        System.out.println(Arrays.toString(array));
    }

    @Override
    public String toString() {
        return "BubbleSort{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
