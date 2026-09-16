import java.util.*;

public class Main {

    // Lambda Function WITHOUT Sorting
    // TC: O(N)
    // SC: O(1) Auxiliary Space
    public static int LambdaFunctionWithoutSorting(int arr[]) {

        // Rather than sorting, we first find the largest element
        int largest = Arrays.stream(arr)
                            .max()                   // Getting maximum
                            .getAsInt();

        return Arrays.stream(arr)
                     .filter(x -> x < largest)      // Filter elements smaller than largest
                     .max()
                     .orElse(-1);                   // Handle if second-largest doesn't exist
    }


    // Lambda Function WITH Sorting
    // TC: O(N log N)
    // SC: O(N) Auxiliary Space
  
    public static int lambdaFunction(int arr[]) {
        return Arrays.stream(arr)
                     .distinct()                    // Remove duplicates
                     .boxed()                       // int -> Integer
                     .sorted(Collections.reverseOrder()) // Sort in descending order
                     .skip(1)                       // Skip the largest
                     .findFirst()
                     .orElse(-1);                   // Handle if second-largest doesn't exist
    }


    // Sorting Function
    // TC: O(N log N)
    // SC: O(log N) Auxiliary Space
  
    public static int Sorting(int arr[]) {

        Arrays.sort(arr);

        int n = arr.length;

        // Start from second-last element
        // and find the first element different from the largest
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != arr[n - 1]) {
                return arr[i];
            }
        }
        System.out.println("Second largest doesn't exist");
        return -1;
    }


    // Normal Loop
    // TC: O(N)
    // SC: O(1)
  
    public static int NormalLoop(int arr[]) {

        int n = arr.length;
        int largest = Integer.MIN_VALUE;                     // taking both as Integer.MIN_VALUE
        int secondLargest = Integer.MIN_VALUE;               // taking both as Integer.MIN_VALUE
        boolean foundSecondLargest = false;                  // if array contains negative number
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];

                // If we already had a previous largest,
                // then it becomes the second-largest
                if (i > 0) {
                    foundSecondLargest = true;
                }
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
                foundSecondLargest = true;                                          // to flag up that second largest exists
            }
        }
        if (!foundSecondLargest) {                                                 // cross checking if array has all numbers same
            System.out.println("Second largest doesn't exist");
            return -1;
        }
        return secondLargest;
    }


    public static void main(String[] args) {

        System.out.println("Hello, World!");

        int arr[] = {10, 25, 7, 45, 18};

        System.out.println(
            "The second largest element is: " + NormalLoop(arr));

        System.out.println(
            "The second largest element is: " + Sorting(arr));

        System.out.println(
            "The second largest element is: " + lambdaFunction(arr));

        System.out.println(
            "The second largest element is: " + LambdaFunctionWithoutSorting(arr));
    }
}
