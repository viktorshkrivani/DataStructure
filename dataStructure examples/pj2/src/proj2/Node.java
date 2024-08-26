package proj2;
// Viktor Shkrivani
// CIS 2353
// Fall 2023
// Project 2


//Represents a single term in a polynomial
public class Node {
    int exponent;
    int coefficient;
    Node nextNode;

    //Constructor
    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.nextNode = null; // Initialize the nextNode to null it is for the last term in the linked list.

    }

    //Methods
    public int getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public Node getNextNode() {
        return nextNode;
    }

    //Sets the reference to the next node in the linked list
    public void setNextNode(Node next) {
        this.nextNode = next;
    }

    //Sets the coefficient of the term
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

}
