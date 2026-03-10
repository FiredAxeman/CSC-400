public class CT5Disc {

    // Recursive method to calculate factorial
    public static int calculateFactorial(int n) {
        // Base case: if n is 1 or 0, the factorial is 1
        if (n <= 1) {
            return 1;
        }
        // Recursive step: n * factorial of (n-1)
        return n * calculateFactorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;
        int result = calculateFactorial(number);
        System.out.println("The factorial of " + number + " is: " + result); 
        // Output: The factorial of 5 is: 120
    }
}