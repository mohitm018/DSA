
import java.util.*;
public class Main {
  public static int LambdaFunctiuonWithoutSorting(int arr[]){
    //rather than sorting with choosed this so we taking out the largest 
   int largest = Arrays.stream(arr)
                        .max()                   //getting Max here
                        .getAsInt();

    return Arrays.stream(arr)
                 .filter(x -> x < largest)           // filtering data smaller than largest
                 .max()
                 .orElse(-1);                        // to handle if all element are same 
  }

  // lambda function here took            TC:O(N log n)    and   SC:O(N)
  public static int lambdaFunction(int arr[]){
    return Arrays.stream(arr)
          .distinct()                                  //removed duplicated
          .boxed()                                     // int -> Integer
          .sorted(Collections.reverseOrder())          //sorted and reversed   
          .skip(1)                                      // skiped largest
          .findFirst()
         .orElse(-1);
  }

  // Sorting function here took            TC:O(N log n)    and   SC:O(N)
  public static int Sorting(int arr[]){                 // we used Sorting here 
     Arrays.sort(arr);

    int n = arr.length;

    for (int i = n - 2; i >= 0; i--) {

        if (arr[i] != arr[n - 1]) {
            return arr[i];
        }
    }

    System.out.println("Second largest does not exist");
    return -1;
  }


    // Normal loop  here took            TC:O(N)    and   SC:O(1)

  public static int NormalLoop(int arr[]){
    int n = arr.length;
    int largest= Integer.MIN_VALUE;
    int secondLargest= Integer.MIN_VALUE;
    for(int i =0;i<n;i++){

      if(arr[i]>largest){
        secondLargest= largest;
        largest= arr[i];
      }else if(arr[i]> secondLargest && arr[i]!= largest){
        secondLargest= arr[i];
      }
    }
    if(secondLargest==Integer.MIN_VALUE){                        // If Arrays has All Elemnt same or Array is with only 1 elemnt
      System.out.println("Second Highest Doesn't exists");
      return -1;
    }
    return secondLargest;
  }
  public static void main(String[] args) {
      System.out.println("Hello, World!");
            int arr[]={10,25,7,45,18};
            System.out.println("The secondLargest element is: "+NormalLoop(arr));
            System.out.println("The secondLargest element is: "+Sorting(arr));

            System.out.println("The secondLargest element is: "+lambdaFunction(arr));

            System.out.println("The secondLargest element is "+LambdaFunctiuonWithoutSorting(arr));


  }
}
