//this is just to remove spaces and then converting it into toLowerCase
    //Ex= My nayan ym -> will be made "mynayanym"
    //  str = str.replaceAll("\\s+", "").toLowerCase();
    

    // This will remove everything except a-z,A-z,0-9 into toLowerCase
    //ex= My,nayan,ym  -> mynayannym
  //   str= str.replaceAll("[^a-zA-Z0-0]","").toLowerCase();


  
import java.util.*;
public class Main {
  //By recursion
  // TC:O(N)   SC:O(N)
  public static boolean isPAlindromeRecursion(String str, int i, int j){

     str= str.replaceAll("[^a-zA-Z0-0]","").toLowerCase();
    if(i>=j){
      return true;
    }
    if(str.charAt(i)!= str.charAt(j)){
      return false;
    }
    return isPAlindromeRecursion(str,i+1,j-1);
  }


   // BY String Builder
  //TC:O(N)   SC:O(N)
  public static boolean isPalindromeStringBuilder(String str){

         str= str.replaceAll("[^a-zA-Z0-0]","").toLowerCase();


    //Optional
    // String reverse = new StringBuilder(str)
    //                                              .reverse()
    //                                              .toString();
    // return  str.equals(reverse);



    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    return str.equals(sb.toString());
  }

  //TC:O(N)    SC:O(1)
  //Vie For LOOP
  public static boolean isPalindromeFor(String str){

     str= str.replaceAll("[^a-zA-Z0-0]","").toLowerCase();

    int n = str.length();
    for(int i=0;i<n/2;i++){
      if(str.charAt(i) != str.charAt(n-1-i)){
        return false;
      }
    }
    return true;
  }
  // Tc:O(N)    Sc:O(1)
  //With While LOOP
  public static boolean isPAlindrome(String str){

    str= str.replaceAll("[^a-zA-Z0-0]","").toLowerCase();

    int n = str.length();
    int i = 0;
    int j =n-1;
    while(i<j){
      if(str.charAt(i)!=str.charAt(j)){
        
        return false;
      }
      i++;
      j--;
    }return true;
  }
  public static void main(String[] args) {
      System.out.println("Hello, World!");
      String str="madam";
      System.out.println(""+isPAlindrome(str));
      String str2="Mohit";
      System.out.println(""+isPAlindrome(str2));

      //For Loop
      System.out.println("For Loop: "+isPalindromeFor(str));
            System.out.println("For Loop: "+isPalindromeFor(str2));



      System.out.println("StringBuilder: "+isPalindromeStringBuilder(str));
            System.out.println("StringBuilder: "+isPalindromeStringBuilder(str2));


      int n = str.length();
      System.out.println("Recursion: "+isPAlindromeRecursion(str,0,n-1));
      int n2= str2.length();
     System.out.println("Recursion: "+isPAlindromeRecursion(str2,0,n2-1));

  }
}
