import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] mat, int k) {
        //Write code here
        int n = mat.length, m = mat[0].length;
        int ans = Integer.MIN_VALUE;
        // row loop
        for(int r1 = 0; r1<n; r1++){
            // each col start rect for that particular r1
            for(int c1 = 0; c1<m; c1++){
                // row 2 loop
                int [][] pref = new int[n][m];
                for(int r2 = r1; r2<n; r2++){
                    // col 2 loop
                    for(int c2 = c1; c2<m; c2++){
                        // rectangle is formed
                        // r2, c2
                        int v1 = 0; // upper rectangle
                        if(r2-1>=0) v1 = pref[r2-1][c2];
                        int v2 = 0; // left rect
                        if(c2-1>=0) v2 = pref[r2][c2-1];
                        int v3 = 0; // corner rec
                        if(r2-1>=0 && c2-1>=0) v3 = pref[r2-1][c2-1];
                        pref[r2][c2] = v1 + v2 - v3 + mat[r2][c2];
                        if(pref[r2][c2] <= k) ans = Math.max(ans, pref[r2][c2]);
                    }
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}
