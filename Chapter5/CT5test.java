import java.util.Arrays;

public class CT5test {
    public static void main(String[] args) {
        // The array of Integer objects provided in the assignment
        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Call the Radix Sort algorithm
        CT5.sort(arr);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}