import java.util.Arrays;

public class CT7Disc {

    public static void main(String[] args) {
        // Initialize an unsorted array of integers
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};
        
        // Print the array before sorting
        System.out.println("Original Array: " + Arrays.toString(numbers));
        
        // Call the recursive merge sort method
        mergeSort(numbers);
        
        // Print the array after sorting
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }

    public static void mergeSort(int[] array) {
        // Base case: arrays with 0 or 1 element are already sorted
        if (array == null || array.length <= 1) {
            return;
        }
        
        // Find the midpoint and create two smaller arrays
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        
        // Populate the left and right arrays
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        
        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves back into the original array
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0; // Index for left array
        int j = 0; // Index for right array
        int k = 0; // Index for the original merged array
        
        // Compare elements and place the smaller one into the original array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        
        // Copy any remaining elements from the left array
        while (i < left.length) {
            array[k++] = left[i++];
        }
        
        // Copy any remaining elements from the right array
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}