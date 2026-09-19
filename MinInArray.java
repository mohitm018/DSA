// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class Main {

  // By min()
  // TC:O(N)    SC:O(1)auxillary
  public static int byminFunction(int arr[]){
    return Arrays.stream(arr)
                 .min()
                 .getAsInt();
  }
  // BY 
  // Tc:O(N)   Sc:O(1)auxillary
  public static int byLambda(int arr[]){
    return Arrays.stream(arr)
                  .reduce((a,b)-> a<b ? a:b)
                  .getAsInt();
  }

  // TC:(Nlog N) sc:O(N)
  public static int bySorting(int arr[]){
    Arrays.sort(arr);

    return arr[0];
  }



  // TC:O(N)    SC:O(1)
  public static int mininArray(int arr[]){
    int n = arr.length;
    int min = Integer.MAX_VALUE;
    for(int i =0;i<n;i++){
      if(min> arr[i]){
        min= arr[i];
      }
    }
    return min;
  }
  public static void main(String[] args) {
      System.out.println("Hello, World!");
      int arr[]={10 ,9,7,5,18};
      System.out.println("Min in Arrays by Normal "+mininArray(arr));
      System.out.println("Min in array by Sorting: "+bySorting(arr));
      System.out.println("Min in array by byLambda : "+byLambda(arr));
      System.out.println("Min in Array b minFunction: "+byminFunction(arr));

  }
}
