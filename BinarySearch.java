import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner gv = new Scanner(System.in);

        // Ask the user for the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int size = gv.nextInt();

        // Create an array of the specified size
        int[] numbers = new int[size];

        // Ask the user to input the elements of the array (must be sorted for binary search)
        System.out.println("Enter the elements of the array in sorted order:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i+1) + ": ");
            numbers[i] = gv.nextInt();
        }

        // Ask the user for the target value
        System.out.print("Enter the value to search for: ");
        int target = gv.nextInt();

        // Binary search variables
        int low = 0;
        int high = numbers.length - 1;
        boolean found = false;

        // Binary search using a loop
        while (low <= high) {
            int mid = (low + high) / 2;

            if (numbers[mid] == target) {
                System.out.println("Target " + target + " found at index " + mid);
                found = true;
                break;
            } else if (numbers[mid] < target) {
                low = mid + 1; // Search the right half
            } else {
                high = mid - 1; // Search the left half
            }
        }

        // If the target was not found
        if (!found) {
            System.out.println("Target " + target + " not found in the array.");
        }

        gv.close();
    }
  }
