import model.BubbleSortArray;
import validate.Validate;

import java.util.Scanner;

public class BubbleSortApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BubbleSortArray bubbleSortArray = new BubbleSortArray();

        while (true) {
            System.out.println("========= Bubble Sort program =========");
            System.out.println("1. Input items of the array");
            System.out.println("2. Sort the array in ascending order");
            System.out.println("3. Sort the array in descending order");
            System.out.println("4. Exit");

            int choice =  Integer.parseInt(Validate.checkIntInPut("^[1-4]$","- Select an option: ","- Invalid option. Please try again: "));

            switch (choice) {
                case 1:
                    bubbleSortArray.inputArray(scanner);
                    break;
                case 2:
                    bubbleSortArray.sortAscending();
                    bubbleSortArray.displayArray();
                    break;
                case 3:
                    bubbleSortArray.sortDescending();
                    bubbleSortArray.displayArray();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
            }
        }    }
}