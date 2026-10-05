/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: SMF.Asra
 * Student ID: 23DA2-0826
 * Responsibility: Stack and Queue implementation
 */
package stack_queue;

public class QueueManager {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueManager() {
        this(10);
    }

    public QueueManager(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        queue = new int[capacity];
        front = 0;
        rear = 0; // The next position available for insertion.
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            // Copy in FIFO order, even when the old buffer has wrapped around.
            int[] larger = new int[queue.length * 2];
            for (int i = 0; i < size; i++) {
                larger[i] = queue[(front + i) % queue.length];
            }
            queue = larger;
            front = 0;
            rear = size;
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue() {
        checkNotEmpty();
        int value = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    public int peek() {
        checkNotEmpty();
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Operation cannot be performed.");
        }
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty.";
        }
        StringBuilder text = new StringBuilder("Front -> ");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                text.append(" ");
            }
            text.append(queue[(front + i) % queue.length]);
        }
        return text.append(" <- Rear").toString();
    }
}
