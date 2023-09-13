import Validate.Validate;
import model.LinearSearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = Integer.parseInt(Validate.checkIntInPut("^[0-9][0-9]*$","- Enter the number of array elements: "));
        LinearSearch search = new LinearSearch(arraySize);
        int range = Integer.parseInt(Validate.checkIntInPut("^[0-9][0-9]*$","- Enter the range for random numbers: "));
        search.generateRandomArray(range);
        search.displayArray();
        int searchNumber = Integer.parseInt(Validate.checkIntInPut("^[0-9][0-9]*$","- Enter the search number: "));
        int foundIndex = search.linearSearch(searchNumber);
        if (searchNumber > range){
            System.out.println("The search number " + searchNumber + " was not found in the array.");
        }else if (foundIndex != -1) {
            System.out.println("The search number " + searchNumber + " was found at index " + foundIndex + " in the array.");
        } else {
            System.out.println("The search number " + searchNumber + " was not found in the array.");
        }
        scanner.close();
    }
}