import model.Circle;
import model.Rectangle;
import model.Triangle;
import validate.Validate;

import java.util.Scanner;

public class ShapeCalculator {
    private static final String regex = "^[0-9]*\\.?[0-9]+$";
    private static final String errorEnter = "- These sides do not form a valid. Please try again: ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====Calculator Shape Program=====");
        double width = Double.parseDouble(Validate.checkIntInPut(regex, "- Please input side width of Rectangle: ", errorEnter));
        double length = Double.parseDouble(Validate.checkIntInPut(regex, "- Please input length of Rectangle: ", errorEnter));
        double radius = Double.parseDouble(Validate.checkIntInPut(regex, "- Please input radius of Circle: ", errorEnter));
        double sideA, sideB, sideC;
        do {
            sideA = Double.parseDouble(Validate.checkIntInPut(regex, "- Please input side A of Triangle: ", errorEnter));
            sideB = Double.parseDouble(Validate.checkIntInPut(regex, "- Please input side B of Triangle: ", errorEnter));
            sideC = Double.parseDouble(Validate.checkIntInPut(regex, "- Please input side C of Triangle: ", errorEnter));
            if (!Triangle.isValidTriangle(sideA, sideB, sideC)){
                System.out.println("- Invalid triangle, please try again.");
            }
        } while (!Triangle.isValidTriangle(sideA, sideB, sideC));
        Circle circle = new Circle(radius);
        Rectangle rectangle = new Rectangle(width, length);
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        circle.printResult();
        rectangle.printResult();
        triangle.printResult();
        scanner.close();
    }
}