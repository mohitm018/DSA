
                              // Tc:O(N)    Sc:O(1)  for all
        
import java.util.*;
public class Main {
  // By Recursion 
  public static int ByRecursion(int arr[], int i){
    if(i==arr.length){
      return 0;
    }
    return arr[i]+ByRecursion(arr,i+1);
  }


  // BY reduce() in lambda  
  public static int byLambda(int arr[]){
    return Arrays.stream(arr)
                 .reduce(0,(a,b)-> a+b);
                 
  }


  // By while loop in java 
  public static int bywhileLoop(int arr[]){
    int n = arr.length;
    int i =0;
    int sum =0;
    while(i<n){
     sum += arr[i];
     i++;
    }
    return sum;
  }

  // By enhanced for Loop 
  public static int byForenhanncedloop(int arr[]){
    int sum =0;
    for(int num: arr){
      sum+=num;
    }
    return sum;
  }
  

  // By lambda Function
  public static int bylambdaFunction(int arr[]){
    return Arrays.stream(arr)
                 .sum();
                 
  }
  

  // By basic normal for LOOP 
  public static int SumOfAllAinArray(int arr[]){
    int n = arr.length;
    int sum =0;
    for(int i =0;i<n;i++){
      sum += arr[i];
    }
    return sum;
  }


  
  public static void main(String[] args) {
      System.out.println("Hello, World!"); 
      int arr[]={10,20,30,40};
      System.out.println("Sum of all in Array is : "+SumOfAllAinArray(arr));
      System.out.println("Sum of All element in Arrays is; "+bylambdaFunction(arr));
      System.out.println("Sum with enhanced for loop: "+byForenhanncedloop(arr));
      System.out.println("Sum by while loop is: " +bywhileLoop(arr));
      System.out.println("Sum by byLambda is: "+byLambda(arr));
      System.out.println("Summ by recursion is: "+ByRecursion(arr,0));
  }
}
