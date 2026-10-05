/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: SMF.Asra
 * Student ID: 23DA2-0826
 * Responsibility: Stack and Queue implementation
 */
package stack_queue;

public class StackManager {
    private int[] stack;
    private int top;

    public StackManager() {
        this(10);
    }

    public StackManager(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top + 1 == stack.length) {
            int[] larger = new int[stack.length * 2];
            for (int i = 0; i <= top; i++) {
                larger[i] = stack[i];
            }
            stack = larger;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        checkNotEmpty();
        int value = stack[top];
        stack[top] = 0;
        top--;
        return value;
    }

    public int peek() {
        checkNotEmpty();
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top + 1;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Operation cannot be performed.");
        }
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty.";
        }
        StringBuilder text = new StringBuilder("Top -> " + stack[top]);
        for (int i = top - 1; i >= 0; i--) {
            text.append("\n       ").append(stack[i]);
        }
        return text.toString();
    }
}
