import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
        int n=sc.nextInt(); 
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr.add(x);
        }
        
        Solution ob=new Solution();
        System.out.println(ob.candies(arr,n));
        
	}
}


class Solution {
    public int candies(ArrayList<Integer> A,int n) {
        //Write code here
        int [] cd = new int[n];
        Arrays.fill(cd, 1);
        // left pass
        for(int i = 1; i<n; i++){
            if(A.get(i) > A.get(i-1)){
                // my rating is higher than my left neighbour
                cd[i] = cd[i-1] + 1;
            }
        }
        // right pass
        for(int i = n-2; i>=0; i--){
            if(A.get(i) > A.get(i+1)){
                // my rating is higher than my right neighbour
                cd[i] = Math.max(cd[i], cd[i+1] + 1);
            }
        }
        int sum = 0;
        for(int c : cd) sum += c;
        return sum;
	
    }
}

