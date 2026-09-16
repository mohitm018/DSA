
import java.util.*;
public class Main {
  public static int LambdaFunctiuonWithoutSorting(int arr[]){
    //rather than sorting with choosed this so we taking out the largest 
    int largest= Arrays.stream(arr)                      
                 .max()                               // Largest int Array
                 .getAsInt();


    return Arrays.stream(arr)
           .filter(x -> x < largest)                  //Comparing with Largest in Array
           .max()                                     //
           .getAsInt();
  }

  // lambda function here took            TC:O(N log n)    and   SC:O(N)
  public static int lambdaFunction(int arr[]){
    return Arrays.stream(arr)
          .distinct()                                  //removed duplicated
          .boxed()                                     // int -> Integer
          .sorted(Collections.reverseOrder())          //sorted and reversed   
          .skip(1)                                      // skiped largest
          .findFirst()
          .get();
  }

  // Sorting function here took            TC:O(N log n)    and   SC:O(N)
  public static int Sorting(int arr[]){                 // we used Sorting here 
    int n = arr.length;
    Arrays.sort(arr); 
    return arr[n-2];
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
