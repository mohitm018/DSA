import java.util.*;
public class Main{

  //Using for loop we can Achieve it as
  // TC:O(N) and SC:O(1)

public static int[]  ForLOOP(int arr[]){
  for(int i =0;i<arr.length/2;i++){
    int temp = arr[i];
    arr[i]= arr[arr.length-1-i];
    arr[arr.length-i-1]= temp;
  }
  return arr;
}


  //Using for loop also it is possible
  //TC:O(N)
  //Sc:O(N)
  
  public static int[] usingForloop(int arr[]){
    int n = arr.length;
    int result[]= new int[n];
    for(int i =0;i<n;i++){
      result[i]= arr[n-1-i];
    }
    return result;
  }


  //Lambda function 
  // Time coomplexi : O(N)
  //Space Complexity: O(N)     Bcz here in lambda function we use toArray() it creates new Array
public static int[] reverseArrayLambdaFunction(int arr[]){
    return java.util.stream.IntStream.range(0, arr.length)
                            .map(i -> arr[arr.length-1-i])
                            .toArray();
}

 // SWapping Nomrmal Method
 //Time Complexity:O(N)
 // Space Complexity:O(1)

  public static int[] reverseArray(int arr[]){
    int n = arr.length;
    int i=0;
    int j = n-1;
    while(i<j){             // look till the middle point and till here eerything gets swapped
      int temp = arr[i];     
      arr[i]= arr[j];
      arr[j]= temp;
      i++;
      j--;
    }
    return arr;
  }
  public static void main(String[]args){
    int arr[]={10,20,30,40,50};
    int result[]= reverseArray(arr);
    System.out.print(Arrays.toString(result)); // converting Array as String

    System.out.println();
        int arr2[]={10,20,30,40,50};

    int result2[] = reverseArrayLambdaFunction(arr2);
    System.out.println(Arrays.toString(result2));

    // System.out.println();
    int arr3[]={10,20,30,40,50};

    System.out.println(Arrays.toString(usingForloop(arr3)));
        System.out.println();
    int arr4[]={10,20,30,40,50};
    System.out.println(Arrays.toString(ForLOOP(arr4)));

  }
}

// Swapping method is always better
