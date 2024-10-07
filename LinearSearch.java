import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner gv = new Scanner(System.in);
        
        // Example array to search
        int[] numbers = {3, 27, 5, 8, 2, 18, 10, 7};
        
        // Ask the user for the target value
        System.out.print("Enter the value to search for: ");
        int target = gv.nextInt();
        
        // Linear search using a loop
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Target " + target + " found at index " + i);
                found = true;
                break;
            }
        }
        
        // If the target was not found
        if (!found) {
            System.out.println("Target " + target + " not found in the array.");
        }
        
        gv.close();
    }
}
