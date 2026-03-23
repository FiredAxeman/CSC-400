import java.util.Arrays;

public class CT5updated {

    public static void main(String[] args) {
        // Sample array to test the radix sort
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        
        System.out.println("Original array: " + Arrays.toString(arr));
        
        // Call the sort method
        sort(arr);
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    /**
     * Main function that implements Radix Sort.
     * Time Complexity: O(n * k)
     * - n is the number of elements in the array.
     * - k is the number of digits in the largest number.
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // Find the maximum number to know the number of digits
        int max = getMax(arr);

        // Do counting sort for every digit. 
        // exp is 10^i where i is the current digit position (1, 10, 100, etc.)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // A utility function to get the maximum value in an array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10]; // Count array for base 10
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it now contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (iterate backward to maintain algorithm stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to the current digit
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}