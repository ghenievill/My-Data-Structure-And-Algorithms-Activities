import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the value to search using Linear Search: ");
        int target = sc.nextInt();
        int linearResult = linearSearch(array, target);
        System.out.print("Linear Search result: " + (linearResult != -1 ? "Found at index " + linearResult : "Not found"));

        Arrays.sort(array);
        System.out.println("Sorted array for binary search: " + Arrays.toString(array));
        System.out.print("Enter the value to search using Binary Search: ");
        target = sc.nextInt();
        int binaryResult = binarySearch(array, target, 0, array.length - 1);
        System.out.println("Binary Search result: " + (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));

        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Merge Sort\n5. Quick Sort");
        int choice = sc.nextInt();

        int[] sortedArray = Arrays.copyOf(array, array.length);
        switch (choice) {
            case 1 : bubbleSort(sortedArray);
            break;
            case 2 : insertionSort(sortedArray);
            break;
            case 3 : selectionSort(sortedArray);
            break;
            case 4 : mergeSort(sortedArray, 0,       sortedArray.length - 1);
            break;
            case 5 : quickSort(sortedArray, 0, sortedArray.length - 1);
            default : System.out.println("Invalid choice");
        }

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                return binarySearch(array, target, low, mid - 1);
            } else {
                return binarySearch(array, target, mid + 1, high);
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int g = 0; g < n - i - 1; g++) {
                if (array[g] > array[g + 1]) {
                    int temp = array[g];
                    array[g] = array[g+ 1];
                    array[g + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int g = i - 1;
            while (g >= 0 && array[g] > key) {
                array[g + 1] = array[g];
                g = g - 1;
            }
            array[g + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int g = i + 1; g < array.length; g++) {
                if (array[g] < array[minIndex]) {
                    minIndex = g;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, g = 0, h = left;
        while (i < n1 && g < n2) {
            if (leftArray[i] <= rightArray[g]) {
                array[h] = leftArray[i];
                i++;
            } else {
                array[h] = rightArray[g];
                g++;
            }
            h++;
        }

        while (i < n1) {
            array[h] = leftArray[i];
            i++;
            h++;
        }

        while (g < n2) {
            array[h] = rightArray[g];
            g++;
            h++;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int g = low; g< high; g++) {
            if (array[g] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[g];
                array[g] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
