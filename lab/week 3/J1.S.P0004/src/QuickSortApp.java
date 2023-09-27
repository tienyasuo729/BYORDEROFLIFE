import model.QuickSort;
import validate.Validate;

import java.util.Scanner;

public class QuickSortApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the size of the array: ","- Only enter numbers, please re-enter: "));
        QuickSort quickSort = new QuickSort(size);
        int maxRange = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the maximum range for random numbers: ","- Only enter numbers, please re-enter: "));
        quickSort.generateRandomArray(maxRange);

        System.out.println("Unsorted Array:");
        quickSort.displayArray();

        quickSort.quickSort();

        System.out.println("Sorted Array:");
        quickSort.displayArray();

        scanner.close();    }
}