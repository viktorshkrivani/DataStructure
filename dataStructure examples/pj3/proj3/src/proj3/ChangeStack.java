package proj3;

import java.util.Scanner;

// Viktor Shkrivani
// Project 3
// CIS 2353
// Fall 2023
// Prof. John P. Baugh
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackEmptyException extends RuntimeException {
    public StackEmptyException(String message) {
        super(message);
    }
}

class ChangeStack {
    private Node top;
    private int numElements;

    public ChangeStack() {
        this.numElements = 0;
        this.top = null;
    }

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        numElements++;
    }

    public int pop() {
        if (top == null) {
            throw new StackEmptyException("Cannot pop from an empty stack");
        }
        int poppedValue = top.data;
        top = top.next;
        numElements--;
        return poppedValue;
    }

    public int peekTop() {
        if (top == null) {
            throw new StackEmptyException("Cannot peek on an empty stack");
        }
        return top.data;
    }

    public void increaseValues(int k, int amount) {
        if (top == null || k <= 0) {
            return; // No elements in the stack or k is non-positive, do nothing
        }

        Node current = top;
        int count = 0;

        while (current != null && count < k) {
            current.data += amount;
            current = current.next;
            count++;
        }
    }

    public void decreaseValues(int k, int amount) {
        if (top == null || k <= 0) {
            return; // No elements in the stack or k is non-positive, do nothing
        }

        Node current = top;
        int count = 0;

        while (current != null && count < k) {
            current.data -= amount;
            current = current.next;
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements to push onto the stack:");
        int numElements = scanner.nextInt();

        ChangeStack stack = new ChangeStack();

        System.out.printf("Enter %d elements to push onto the stack:\n", numElements);
        for (int i = 0; i < numElements; i++) {
            int element = scanner.nextInt();
            stack.push(element);
        }

        System.out.println("\nStack before increasing values:");
        printStack(stack);

        System.out.println("\nEnter the number of elements to increase:");
        int numIncrease = scanner.nextInt();

        System.out.println("\nEnter the amount to increase by:");
        int increaseAmount = scanner.nextInt();

        stack.increaseValues(numIncrease, increaseAmount);

        System.out.println("\nStack after increasing values:");
        printStack(stack);

        System.out.println("\nEnter the number of elements to decrease:");
        int numDecrease = scanner.nextInt();

        System.out.println("\nEnter the amount to decrease by:");
        int decreaseAmount = scanner.nextInt();

        stack.decreaseValues(numDecrease, decreaseAmount);

        System.out.println("\nStack after decreasing values:");
        printStack(stack);
    }

    private static void printStack(ChangeStack stack) {
        Node current = stack.top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    }
