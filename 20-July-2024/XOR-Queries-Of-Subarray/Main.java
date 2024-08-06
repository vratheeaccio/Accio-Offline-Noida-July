import java.util.*;

public class Main { public static void main(String[] args) throws Throwable { 
	     Scanner sc = new Scanner(System.in); 
	     int n = sc.nextInt();
	     int q = sc.nextInt(); 
	     int [] arr= new int[n]; 
	     for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         } 
    
         int [][] queries= new int[q][2]; 
         
        for(int i=0;i<q;i++){ 
            for(int j=0;j<2;j++){ 
                queries[i][j]=sc.nextInt(); 
            } 
        } 
    
        Solution Obj= new Solution();
        int [] result = Obj.xorQueries(arr,queries);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
    }
  }
} 

class Solution{

 public int[] xorQueries(int[] arr, int[][] ranges) {
            // write your code here.
     int n = arr.length, q = ranges.length;
            int [] ans = new int[q];
            int [] pref = new int[n];
            pref[0] = arr[0];
            for(int i = 1; i<n; i++) pref[i] = pref[i-1] ^ arr[i];
            for(int i = 0; i<q; i++){
                int l = ranges[i][0];
                int r = ranges[i][1];
                if(l>0)
                    ans[i] = pref[r] ^ pref[l-1];
                else ans[i] = pref[r];
            }
            return ans;
    }
}
