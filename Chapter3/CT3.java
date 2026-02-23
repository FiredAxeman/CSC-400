public class CT3 {
    public static int CT3(int[] arr) {
        int n = arr.length;
        // Calculate the expected sum of all numbers from 1 to n + 1
        // We use long to prevent integer overflow for very large arrays
        long expectedSum = (long)(n + 1) * (n + 2) / 2;
        // Calculate the actual sum of the elements present in the array
        long actualSum = 0;
        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
        }
        // The missing number is the difference between the two sums
        return (int)(expectedSum - actualSum);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println("Missing number: " + CT3(arr));
    }
}