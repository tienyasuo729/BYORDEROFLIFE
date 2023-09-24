package model;

public class Calculator {
    private double memory;

    public Calculator() {
        this.memory = 0.0;
    }

    public double getMemory() {
        return memory;
    }

    public void add(double num) {
        memory += num;
    }

    public void subtract(double num) {
        memory -= num;
    }

    public void multiply(double num) {
        memory *= num;
    }

    public void divide(double num) {
        if (num != 0) {
            memory /= num;
        } else {
            System.out.println("Error: Division by zero.");
        }
    }

    public void calculateExponent(double num) {
        memory = Math.pow(memory, num);
    }
}
