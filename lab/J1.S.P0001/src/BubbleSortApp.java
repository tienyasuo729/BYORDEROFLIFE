import model.BubbleSort;
import validate.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSortApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the size of the array: ","- Only enter numbers, please re-enter: "));
        BubbleSort bubbleSort = new BubbleSort(size);
        int maxRange = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the maximum range for random numbers: ","- Only enter numbers, please re-enter: "));
        bubbleSort.generateRandomArray(maxRange);
        System.out.println("Unsorted Array:");
        bubbleSort.displayArray();
        bubbleSort.sort();
        System.out.println("Sorted Array:");
        bubbleSort.displayArray();
        scanner.close();
    }
}