package model;

public class Converter {
    public String convert(String inputValue, int inputBase, int outputBase) {
        try {
            int decimalValue = 0;
            if (inputBase == 1) {
                decimalValue = Integer.parseInt(inputValue, 2);
            } else if (inputBase == 2) {
                decimalValue = Integer.parseInt(inputValue);
            } else if (inputBase == 3) {
                decimalValue = Integer.parseInt(inputValue, 16);
            }

            if (outputBase == 1) {
                return Integer.toBinaryString(decimalValue);
            } else if (outputBase == 2) {
                return Integer.toString(decimalValue);
            } else if (outputBase == 3) {
                return Integer.toHexString(decimalValue).toUpperCase();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input value.");
        }

        return "Invalid conversion";
    }
}
