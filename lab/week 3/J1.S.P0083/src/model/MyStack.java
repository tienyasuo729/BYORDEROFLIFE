package model;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    // Push a value to the stack
    public void push(T value) {
        stackValues.add(value);
    }

    // Pop a value from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int lastIndex = stackValues.size() - 1;
        T value = stackValues.get(lastIndex);
        stackValues.remove(lastIndex);
        return value;
    }

    // Get a value from the stack without removing it
    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int lastIndex = stackValues.size() - 1;
        return stackValues.get(lastIndex);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stackValues.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return stackValues.size();
    }
}
