package proj2;
// Viktor Shkrivani
// CIS 2353
// Fall 2023
// Project 2
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class Polynomial {
    private Node head;

    public Polynomial() {
        head = null; // initializes the head of the linked list to null
    }

    public Polynomial(String poly) {
        head = null;
        if (poly != null && !poly.isEmpty()) {
            String[] terms = poly.split("\\s*[+]\\s*"); // splits the input string poly into an array of terms

            for (String term : terms) {
                String[] parts = term.split("x\\^"); // splits each term into its coefficient and exponent parts

                int coefficient;
                int exponent;

                // here if there is both a coefficient and an exponent
                if (parts.length == 2) {
                    coefficient = Integer.parseInt(parts[0]);
                    exponent = Integer.parseInt(parts[1]);
                    // here means that is either a constant term or a term with just 'x'
                } else if (parts.length == 1) {
                    if (parts[0].endsWith("x")) {
                        coefficient = Integer.parseInt(parts[0].substring(0, parts[0].length() - 1));
                        exponent = 1;
                        // is not 1 or 2, it indicates an invalid polynomial format
                    } else {
                        coefficient = Integer.parseInt(parts[0]);
                        exponent = 0;
                    }
                } else {
                    throw new IllegalArgumentException("Invalid polynomial format: " + term);
                }
                // calls the addTerm method to add the parsed coefficient and exponent
                addTerm(coefficient, exponent);
            }
        }
    }

    // initializes a new Polynomial object and set head of the new polynomial
    // to be a deep copy of the head of the otherPoly
    // by calling deepCopy
    public Polynomial(Polynomial otherPoly) {
        head = deepCopy(otherPoly.head);
    }

    private Node deepCopy(Node node) {
        if (node == null) {
            return null;
        }

        // creates a new node in the copy linked list with the same coefficient
        // and exponent as the current node in the original linked list
        Node copyNode = new Node(node.getCoefficient(), node.getExponent());
        // calls deepCopy on the next node in the original linked list and sets the result as the next node in the copy linked list
        copyNode.setNextNode(deepCopy(node.getNextNode()));
        // then returns the copy of the current node
        return copyNode;
    }

    public void addTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head; // starts at the head of the linked list
            Node previous = null; // keeps track of the previous node
            // then goes through the linked list until it finds a node with a smaller exponent or reaches the end
            while (current != null && current.getExponent() > exponent) {
                previous = current;
                current = current.getNextNode();
            }
            // is same exponent, updates its coefficient by adding the new coefficient to it
            if (current != null && current.getExponent() == exponent) {
                current.setCoefficient(current.getCoefficient() + coefficient);
            } else {
                // new Node becomes the current
                newNode.setNextNode(current);
                if (previous != null) { // if there is a previous node, set its next node to the new node
                    previous.setNextNode(newNode);
                } else {
                    // so if there's no Node sets the head to a new node
                    head = newNode;
                }
            }
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            // check if current coefficient is not zero and if exponent of the current term is 0
            if (current.getCoefficient() != 0) {
                if (current.getExponent() == 0) {
                    System.out.print(current.getCoefficient());
                    // if exponent is 1
                } else if (current.getExponent() == 1) {
                    System.out.print(current.getCoefficient() + "x");
                } else {
                    System.out.print(current.getCoefficient() + "x^" + current.getExponent());
                }
                // looks for another term in the polynomial and print the plus sign
                if (current.getNextNode() != null) {
                    System.out.print(" + ");
                }
            }
            current = current.getNextNode();
        }
        System.out.println();
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // without this the output will make no sense
        Node current = head;
        boolean isFirstTerm = true; // looks if is the first term in the polynomial

        while (current != null) {
            if (current.getCoefficient() != 0) { // checks if the current term is not zero
                if (!isFirstTerm) {
                    sb.append(" + "); // if not the first term add the sign in between
                }
                isFirstTerm = false;

                if (current.getCoefficient() != 1 || current.getExponent() == 0) {
                    sb.append(current.getCoefficient()); // looks if is not equal to 1 or exponent zero and appends th coefficient
                }

                if (current.getExponent() > 0) { // if the term greater than 0
                    sb.append("x"); // includes x for the variable
                    if (current.getExponent() > 1) { // exponent greater than 1
                        sb.append("^").append(current.getExponent()); // shows the exponent using the sign
                    }
                }
            }
            current = current.getNextNode(); // moves to the next term
        }

        return sb.toString(); // converts the string build to a string and shows the final polynomial

    }

    // adds poly and returns a new one
    public static Polynomial add(Polynomial poly1, Polynomial poly2) {
        // checks if the pony is null
        if (poly1 == null || poly2 == null) {
            throw new IllegalArgumentException("Polynomials cannot be null.");
        }

        // starts a new polynomial to store the sum
        Polynomial result = new Polynomial();
        Node current1 = poly1.head;
        Node current2 = poly2.head;

        // the loop here will go till the currents will become null
        while (current1 != null || current2 != null) {
            int coefficient1 = (current1 != null) ? current1.getCoefficient() : 0;
            int exponent1 = (current1 != null) ? current1.getExponent() : Integer.MIN_VALUE;
            int coefficient2 = (current2 != null) ? current2.getCoefficient() : 0;
            int exponent2 = (current2 != null) ? current2.getExponent() : Integer.MIN_VALUE;

            // compare them together
            if (exponent1 > exponent2) {
                // add them to the new polynomial
                result.addTerm(coefficient1, exponent1);
                // moves to the next term
                current1 = current1.getNextNode();
            } else if (exponent2 > exponent1) {
                result.addTerm(coefficient2, exponent2);
                current2 = current2.getNextNode();
            } else {
                // just adds the with same exponents
                result.addTerm(coefficient1 + coefficient2, exponent1);
                current1 = current1.getNextNode();
                current2 = current2.getNextNode();
            }
        }

        return result;
    }
}
public class Polynomials {
    public static void main(String[] args) {
        ArrayList<Polynomial> polynomialList = new ArrayList<>();

        // trying to read polynomials form a file
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\vikto\\OneDrive\\Documents\\GitHub\\examples\\proj2\\polynomials.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                Polynomial poly = new Polynomial(line);
                polynomialList.add(poly);
            }
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("List of Polynomials:");
            for (int i = 0; i < polynomialList.size(); i++) {
                System.out.println(i + ": " + polynomialList.get(i));
            }

            System.out.println("Which do you wish to add? Enter -1 to exit: ");
            String input = scanner.nextLine();

            try {
                int minusInput = Integer.parseInt(input);
                if (minusInput < 0) {
                    break; // Exit the loop
                }
            } catch (NumberFormatException e) {
                System.out.println();
            }


                String[] choices = input.split("\\s+");

            if (choices.length != 2) {
                System.out.println("Add Spaces, Add Spaces, Add Spaces.");
                continue; // start over
            }

            try {
                int choice = Integer.parseInt(choices[0]);
                int secondChoice = Integer.parseInt(choices[1]);

                if (choice < 0 || secondChoice < 0 || choice >= polynomialList.size() || secondChoice >= polynomialList.size()) {
                    System.out.println("Enter valid polynomial indices.");
                    continue; // start over
                }


                Polynomial selectedPoly1 = polynomialList.get(choice);
                Polynomial selectedPoly2 = polynomialList.get(secondChoice);
                Polynomial result = Polynomial.add(selectedPoly1, selectedPoly2);
                polynomialList.add(result);

            } catch (NumberFormatException e) {
                System.out.println("Add Spaces, Add Spaces, Add Spaces.");
            }

        } while (true); // makes the loop go forever


    }
}