/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: J.Abdullah
 * Student ID: 23DA2-0575
 * Responsibility: Array and Searching implementation
 */
package array_searching;

public class ArrayManager {
    private int[] data;
    private int size;

    public ArrayManager() {
        this(10);
    }

    public ArrayManager(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        data = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == data.length) {
            int[] larger = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                larger[i] = data[i];
            }
            data = larger;
        }
        data[size] = value;
        size++;
    }

    // Delete only the first match, then close the gap.
    public boolean delete(int value) {
        int index = search(value);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = 0;
        return true;
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // Return a copy so callers cannot change the internal array.
    public int[] getValues() {
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = data[i];
        }
        return values;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
        } else {
            System.out.println("Current Array:");
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                text.append(", ");
            }
            text.append(data[i]);
        }
        return text.append("]").toString();
    }
}
