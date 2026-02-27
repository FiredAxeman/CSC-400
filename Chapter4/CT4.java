import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class CT4 {

    public int evaluatePostfix(String postfixExpression) throws IllegalArgumentException {
        if (postfixExpression == null || postfixExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty expression");
        }

        Stack<Integer> stack = new Stack<>();
        String[] tokens;

        // If the expression has spaces, split by spaces to support multi-digit numbers.
        // Otherwise, split character by character to support the "42*3+" format.
        if (postfixExpression.contains(" ")) {
            tokens = postfixExpression.trim().split("\\s+");
        } else {
            tokens = postfixExpression.split("");
        }

        for (String token : tokens) {
            // If the token is an operator
            if (isOperator(token)) {
                // An operator needs at least two operands in the stack
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: Missing operand");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);
            } 
            // If the token is an operand
            else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid postfix expression: Unknown token '" + token + "'");
                }
            }
        }

        // At the end of a valid expression, exactly one item should remain in the stack
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: Too many operands");
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/") || token.equals("%");
    }

    private int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": 
                if (operand2 == 0) throw new ArithmeticException("Division by zero");
                return operand1 / operand2;
            case "%": 
                if (operand2 == 0) throw new ArithmeticException("Modulo by zero");
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    // Method to read and evaluate expressions from a text file
    public void evaluateFile(String filePath) {
        System.out.println("--- Reading from file: " + filePath + " ---");
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String expression = scanner.nextLine();
                if (!expression.trim().isEmpty()) {
                    printEvaluation(expression);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found (" + filePath + ")");
        }
    }

    public void printEvaluation(String expression) {
        try {
            int result = evaluatePostfix(expression);
            System.out.println("Expression: [" + expression + "] -> Result: " + result);
        } catch (Exception e) {
            System.out.println("Expression: [" + expression + "] -> Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CT4 calculator = new CT4();

        System.out.println("--- Hardcoded Examples ---");
        
        // Example 1: Valid Expression (Single digits, no spaces)
        String expression1 = "42*3+";
        calculator.printEvaluation(expression1);

        // Example 2: Valid Expression (Single digits, no spaces)
        String expression2 = "53+7*";
        calculator.printEvaluation(expression2);

        // Example 3: Invalid Expression (Missing operand)
        String expression3 = "42*+"; 
        calculator.printEvaluation(expression3);

        // Example 4: Multi-digit Expression (Requires spaces)
        String expression4 = "100 25 / 4 *"; 
        calculator.printEvaluation(expression4);
        
        System.out.println();

        // Testing the file reader capability
        calculator.evaluateFile("expressions.txt");
        //replace "expressions.txt" with the actual path to your text file containing postfix expressions
    }
}