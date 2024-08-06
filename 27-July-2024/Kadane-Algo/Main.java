import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n){
        //Write code here
        long cursum = 0, ans = Long.MIN_VALUE;
        for(int i = 0; i<n; i++){
            cursum += a[i];
            ans = Math.max(cursum, ans);
            if(cursum<0) cursum = 0;
        }
        return ans;
    }
}
