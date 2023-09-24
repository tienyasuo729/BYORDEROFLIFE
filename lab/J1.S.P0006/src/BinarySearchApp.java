import model.BinarySearch;
import validate.Validate;

import java.util.Scanner;

public class BinarySearchApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the size of the array: ","- Only enter numbers, please re-enter: "));

        BinarySearch binarySearch = new BinarySearch(size);

        int maxRange = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the maximum range for random numbers: ","- Only enter numbers, please re-enter: "));

        binarySearch.generateRandomArray(maxRange);

        binarySearch.sortArray();

        System.out.println("Sorted Array:");
        binarySearch.displayArray();

        int target = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$","- Enter the number to search for: ","- Only enter numbers, please re-enter: "));

        int index = binarySearch.binarySearch(target);

        if (index != -1) {
            System.out.println("Found " + target + " at index " + index);
        } else {
            System.out.println(target + " not found in the array.");
        }

        scanner.close();
    }
}