import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
        // Write your code here
        int kad = Integer.MIN_VALUE, pcursum = 0, rkad = Integer.MAX_VALUE, ncursum = 0, totsum = 0;
        for(int i = 0; i<n; i++){
            // simple kadane
            pcursum += arr[i];
            kad = Math.max(kad, pcursum);
            if(pcursum<0) pcursum = 0;
            // rev kadane
            ncursum += arr[i];
            rkad = Math.min(rkad, ncursum);
            if(ncursum > 0) ncursum = 0;
            // total sum
            totsum += arr[i];
        }
        // all ele are -ive
        if(totsum == rkad) return kad;
        
        int ans = Math.max(totsum-rkad, kad);
        return ans;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}
