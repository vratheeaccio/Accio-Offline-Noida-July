import java.util.*;

class Solution {
    
    public int filling(int A[],int B[],int n) {
        //Write your code here
        // first check for sum of gas >= sum of cost
        int sa = 0, sc = 0;
        for(int a : A) sa += a;
        for(int c : B) sc += c;
        if(sc > sa) return -1; // never comp lap
        int sum = 0, ind = 0;

        for(int i = 0; i<n; i++){
            sum += (A[i] - B[i]);
            if(sum < 0){
                sum = 0;
                ind = i+1;
            }
        }
        return ind;
	
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}

