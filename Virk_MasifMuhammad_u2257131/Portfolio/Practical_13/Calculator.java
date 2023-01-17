package Portfolio.Practical_13;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Continue processing expressions until the user chooses to quit
        while (true) {
            Stack<String> operandStack = new Stack<>();

            // Prompt the user to enter an expression
            System.out.println("Enter the postfix expression to be evaluated (with a space between each operand and operator) or Q to quit:");
            String expression = input.nextLine();

            // Check if the user wants to quit
            if (expression.equalsIgnoreCase("Q")) {
                break;
            }

            // Split the expression into tokens
            String[] tokens = expression.split(" ");

            // Print the table header
            System.out.printf("%-20s%-20s%-20s%6s\n", "Method", "Operand(s)", "Result", "Stack Contents ( ... → top)");

            // Evaluate the expression
            for (String token : tokens) {
                try {
                    // If the token is numeric, it must be an operand
                    // Push it onto the stack
                    double operand = Double.parseDouble(token);
                    operandStack.push(String.valueOf(operand));

                    // Print the current state of the stack
                    System.out.printf("%-20s%-20s%-20s%6s\n", "push(" + operand + ")", "-", operand, "(" + operandStack + ")");
                } catch (NumberFormatException nfe) {
                    // If the token is not numeric, it must be an operator
                    // Pop the top two operands from the stack
                    double operand2 = Double.parseDouble(operandStack.pop());
                    double operand1 = Double.parseDouble(operandStack.pop());

                    // Print the current state of the stack
                    System.out.printf("%-20s%-20s%-20s%6s\n", "pop()", operand1, "-", "(" + operandStack + ")");
                    System.out.printf("%-20s%-20s%-20s%6s\n", "pop()", operand2, "-", "(" + operandStack + ")");

                    // Perform the operation
                    double result;
                    switch (token) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            result = operand1 / operand2;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operator: " + token);
                    }

                    // Push the result onto the stack
                    operandStack.push(String.valueOf(result));

                    // Print the current state of the stack
                    System.out.printf("%-20s%-20s%-20s%6s\n", "push(" + result + ")", "-", result, "(" + operandStack + ")");
                }
            }

            // The result of the expression will be the only element remaining on the stack
            double result = Double.parseDouble(operandStack.pop());
            System.out.println("Result: " + result);
        }
    }
}


