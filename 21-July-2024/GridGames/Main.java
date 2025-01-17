import java.util.*;

class Solution {

    public long solve(int grid[][]) {
        // Your code here
        int n = grid[0].length;
        long [][] pref = new long[2][n];
        pref[0][0] = grid[0][0];
        pref[1][0] = grid[1][0];
        for(int i = 1; i<n; i++){
            // 1st row
            pref[0][i] = pref[0][i-1] + grid[0][i];
            // 2nd row
            pref[1][i] = pref[1][i-1] + grid[1][i];
        }
        // explore choices for r2
        long ans = Long.MAX_VALUE;
        for(int i = 0; i<n; i++){
            long fc = pref[0][n-1] - pref[0][i];
            long sc = 0;
            if(i>0) sc = pref[1][i-1];
            long temp = Math.max(fc, sc);
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}
