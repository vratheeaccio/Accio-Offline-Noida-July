import java.util.*;
import java.io.*;
class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
       // Write your code here
       int n = nums.length;
       Arrays.sort(nums);
       List<List<Integer>> ans = new ArrayList<>();
       // quads
       // 1st val of quad
       for(int i = 0; i<n-3; i++){
           if(i-1 >= 0 && nums[i] == nums[i-1]) continue;
           // j loop 2 val of quad
           for(int j = i+1; j<n-2; j++){
               if(j-1 != i && nums[j] == nums[j-1]) continue;
               // 3rd value of quad
               int nt = target - (nums[i] + nums[j]);
               int l = j+1, r = n-1;
               while(l<r){
                   if(nums[l] + nums[r] == nt){
                       List<Integer> tmp = new ArrayList<>();
                       tmp.add(nums[i]);tmp.add(nums[j]);tmp.add(nums[l]);tmp.add(nums[r]);
                       ans.add(tmp);
                       l++; r--;
                       while(l<r && nums[l] == nums[l-1]) l++;
                       while(l<r && nums[r] == nums[r+1]) r--;
                   }
                   else if(nums[l] + nums[r] > nt) r--;
                   else l++;
               }
           }
       }
       return ans;
   }
}

public class Main
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}
