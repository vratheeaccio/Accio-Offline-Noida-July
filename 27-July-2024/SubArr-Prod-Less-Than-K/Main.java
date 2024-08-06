import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Write code here
        int ans = 0;
        int cp = 1;
        int i = 0, j = 0, n = nums.length;
        while(j<n){
            cp *= nums[j];
            if(cp < k) ans += (j-i) + 1;
            else{
                while(i<=j && cp >= k){
                    cp /= nums[i];
                    i++;
                }
                ans += (j-i)+1;
            }
            j++;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}
