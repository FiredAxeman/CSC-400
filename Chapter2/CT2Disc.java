public class CT2Disc {
    public static void main(String[] args) {
        // 1. Declaration and Instantiation
        // We want an array that holds exactly 5 integers.
        int[] scores = new int[5];

        // 2. Initialization (Populating the array)
        scores[0] = 95;
        scores[1] = 88;
        scores[2] = 72;
        scores[3] = 90;
        scores[4] = 85;

        // 3. Accessing data
        System.out.println("The first score is: " + scores[0]); // Output: 95
        System.out.println("The size of the array is: " + scores.length); // Output: 5
    }
}