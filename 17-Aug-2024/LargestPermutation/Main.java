import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int[] largestPermutation(int[] A, int b) {
        //Write your code here
        int n = A.length;
        int [] ind = new int[n+1];
        for(int i = 0; i<n; i++){
            ind[A[i]] = i;
        }
        // run a loop from 0 to n-1st index
        for(int i = 0; i<n; i++){
            if(b == 0 ) break;
            if(A[i] == n-i) continue;
            // find out index of n-i and swap that with ith index
            int indOfLargestValue = ind[n-i];
            // swap indOfLargestValue, with i in A 
            int temp = A[i];
            A[i] = A[indOfLargestValue];
            A[indOfLargestValue] = temp;
            // updating their index in ind array
            ind[temp] = indOfLargestValue;
            ind[A[i]] = i;
            b--;
        }
        return A;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();

        int b =sc.nextInt();
        Solution obj= new Solution();
        int [] ans = obj.largestPermutation(A, b);

        for(int i=0;i<n;i++)
            System.out.print(ans[i]+" ");
    }
}
