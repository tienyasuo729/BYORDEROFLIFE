package model;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    private int[] array;

    public BinarySearch(int size) {
        array = new int[size];
    }

    public void generateRandomArray(int maxRange) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxRange + 1);
        }
    }

    public void sortArray() {
        Arrays.sort(array);
    }

    public int binarySearch(int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Element found
            } else if (array[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Element not found
    }

    public void displayArray() {
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(array));
    }
}
