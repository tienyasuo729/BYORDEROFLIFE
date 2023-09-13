import model.Converter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Tạo một đối tượng Converter
            Converter converter = new Converter();
            // Hiển thị menu để chọn hệ số đầu vào
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

            // Hiển thị menu để chọn hệ số đầu ra
            System.out.println("Choose the output base:");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            System.out.print("Enter your choice: ");
            int outputBaseChoice = scanner.nextInt();

            // Nhập giá trị đầu vào
            System.out.print("Enter the input value: ");
            String inputValue = scanner.next();

            // Thực hiện chuyển đổi dựa trên các lựa chọn
            String outputValue = converter.convert(inputValue, inputBaseChoice, outputBaseChoice);

            // Hiển thị kết quả
            System.out.println("Output value: " + outputValue);
        }

        scanner.close();    }
}