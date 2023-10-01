import model.BMI;
import model.Calculator;
import validate.Validate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double num1;

        while (true) {
            System.out.println("Calculator Menu:");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");

            int choice = Integer.parseInt(Validate.checkIntInPut("^[1-3]$","- Select an option (1/2/3): ","- Invalid choice. Please select a valid option (1/2/3): "));

            switch (choice) {
                case 1:
                    calculator.add(Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter a number: ","- Invalid data, please enter decimal numbers only: ")));
                    while (true){
                        char operator = Validate.checkIntInPut("^[+\\-*/=]*$","- Enter an operator (+, -, *, /, ^, =): ","- Invalid operator, please re-enter: ").charAt(0);
                        switch (operator) {
                            case '+':
                                num1 = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter a number: ","- Invalid data, please enter decimal numbers only: "));
                                calculator.add(num1);
                                break;
                            case '-':
                                num1 = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter a number: ","- Invalid data, please enter decimal numbers only: "));
                                calculator.subtract(num1);
                                break;
                            case '*':
                                num1 = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter a number: ","- Invalid data, please enter decimal numbers only: "));
                                calculator.multiply(num1);
                                break;
                            case '/':
                                num1 = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter a number: ","- Invalid data, please enter decimal numbers only: "));
                                calculator.divide(num1);
                                break;
                            case '^':
                                num1 = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter a number: ","- Invalid data, please enter decimal numbers only: "));
                                calculator.calculateExponent(num1);
                                break;
                            case '=':
                                break;
                        }
                        System.out.println("Result: " + calculator.getMemory());
                        if (operator == '='){
                            break;
                        }
                    }
                    break;
                case 2:
                    double weight = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter your weight (kg): ","- Invalid data, please enter decimal numbers only: "));
                    double height = Double.parseDouble(Validate.checkIntInPut("^-?\\d+(\\.\\d+)?$","- Enter your height (m): ","- Invalid data, please enter decimal numbers only: "));

                    BMI bmiCalculator = new BMI(weight, height);

                    System.out.println("BMI: " + bmiCalculator.calculateBMI());
                    System.out.println("Status: " + bmiCalculator.getStatus());
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}