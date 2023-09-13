import model.Converter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Converter converter = new Converter();
            System.out.println("Choose the input base:");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int inputBaseChoice = scanner.nextInt();
            if (inputBaseChoice == 4) {
                System.out.println("Goodbye!");
                break;
            }
            System.out.println("Choose the output base:");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            System.out.print("Enter your choice: ");
            int outputBaseChoice = scanner.nextInt();
            System.out.print("Enter the input value: ");
            String inputValue = scanner.next();
            String outputValue = converter.convert(inputValue, inputBaseChoice, outputBaseChoice);
            System.out.println("Output value: " + outputValue);
        }

        scanner.close();    }
}