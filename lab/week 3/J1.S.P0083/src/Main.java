import model.MyStack;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        // Push some values onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Get and print the top value of the stack
        System.out.println("Top element: " + stack.get());

        // Pop and print values from the stack
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }    }
}