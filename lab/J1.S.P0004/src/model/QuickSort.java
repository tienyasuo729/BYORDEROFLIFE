package model;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private int[] array;

    public QuickSort(int size) {
        array = new int[size];
    }

    public void generateRandomArray(int maxRange) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxRange + 1);
        }
    }

    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[low]; // Choose the pivot as the first element
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= j && array[i] <= pivot) {
                i++;
            }

            while (array[j] >= pivot && j >= i) {
                j--;
            }

            if (j < i) {
                break;
            }

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;
    }

    public void displayArray() {
        System.out.println("Array Elements:");
        System.out.println(Arrays.toString(array));
    }
}
