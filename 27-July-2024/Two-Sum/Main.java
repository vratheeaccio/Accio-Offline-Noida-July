import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int[] twoSum(int[] A, int target) {
       // Your code here
        int l = 0, r = A.length-1;
        int [] ans = new int[2];
        
        while(l<r){
            // logic
            if(A[l] + A[r] == target){
                ans[0] = l+1; ans[1] = r+1;
                break;
            }
            else if(A[l] + A[r] > target) r--;
            else l++;
        }
        return ans;
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}




