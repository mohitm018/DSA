// Day-1
//Q - Find the Largent Element in an Array

import java.util.*;
public class Main {

  //By using max()
  public static int maxByLambda(int arr[]){
    return Arrays.stream(arr)
                 .max()
                 .getAsInt();
  }
  // TC:O(n^2)  SC:O(1) 
  public static int Java8FUnction(int arr[]){

    return Arrays.stream(arr).
    filter(x -> Arrays.stream(arr)
                                 .allMatch(y -> x >= y))
          .findFirst()
          .getAsInt();
  }



 // TC:O(n) sc:O(1)
 public static int LambdaFunction(int arr[]){
  return Arrays.stream(arr).
  reduce((a,b) -> a > b ? a : b).
  getAsInt();



 }
  //TC:O(n log n)  SC:O(log n)
  public static int withSort(int arr[]){
    int n = arr.length;
    Arrays.sort(arr);
    return arr[n-1];
  }




  //First basic Normal LOOP with TC:O(N) & SC:(1)
  public static int largestElement(int arr[]){
    int n = arr.length;
    int max= Integer.MIN_VALUE;
    for(int i =1;i<n;i++){
      if(arr[i]>max){
        max=arr[i];
      }
    }
    return max;
  }
  public static void main(String[] args) {
      System.out.println("Hello, World!");
      int arr[]={10,25,7,45,18};
      //System.out.println("Max element by lambda by max(): "+maxByLambda(arr))      //Tc:O(N)            Sc:O(1)
      // System.out.println(largestElement(arr));                                    //-->TC:O(N)         SC:O(1)
      // System.out.print(withSort(arr));                                            //-->TC:O(N log N)   SC:O(log N)
      // System.out.print(LambdaFunction(arr));                                      //-->TC:O(N)         SC:O(1)
      // System.out.println(Java8FUnction(arr));                                     //-->TC:O(N^2)       SC:O(1)




      //Conclusion= Here Looking the scenario we will prefer Looking for largest Element in Normal
      // Loop and then other better choice could be lambda function 
      // other two are good but not good  as per Time complexity and Space Complexity

  }
}
