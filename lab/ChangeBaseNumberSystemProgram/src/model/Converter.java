package model;

public class Converter {
    public String convert(String inputValue, int inputBase, int outputBase) {
        try {
            // Chuyển đổi giá trị đầu vào thành hệ số thập phân
            int decimalValue = 0;
            if (inputBase == 1) {
                decimalValue = Integer.parseInt(inputValue, 2); // Chuyển từ nhị phân sang thập phân
            } else if (inputBase == 2) {
                decimalValue = Integer.parseInt(inputValue); // Chuyển từ thập phân sang thập phân
            } else if (inputBase == 3) {
                decimalValue = Integer.parseInt(inputValue, 16); // Chuyển từ thập lục phân sang thập phân
            }

            // Chuyển đổi giá trị thập phân thành hệ số đầu ra
            if (outputBase == 1) {
                return Integer.toBinaryString(decimalValue); // Chuyển từ thập phân sang nhị phân
            } else if (outputBase == 2) {
                return Integer.toString(decimalValue); // Chuyển từ thập phân sang thập phân
            } else if (outputBase == 3) {
                return Integer.toHexString(decimalValue).toUpperCase(); // Chuyển từ thập phân sang thập lục phân
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input value.");
        }

        return "Invalid conversion";
    }
}
