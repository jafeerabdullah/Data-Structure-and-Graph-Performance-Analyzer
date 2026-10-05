/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: MSM.Dilsath
 * Student ID: 23DA2-0576
 * Responsibility: Linked List implementation
 */
package linked_list;

public class LinkedListManager {
    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedListManager() {
        head = null;
        size = 0;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public boolean delete(int value) {
        if (head == null) {
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        Node previous = head;
        Node current = head.next;
        while (current != null) {
            if (current.data == value) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    // Positions are zero-based, matching ArrayManager.search().
    public int search(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Linked List is empty.";
        }
        StringBuilder text = new StringBuilder();
        Node current = head;
        while (current != null) {
            text.append(current.data).append(" -> ");
            current = current.next;
        }
        return text.append("null").toString();
    }
}
