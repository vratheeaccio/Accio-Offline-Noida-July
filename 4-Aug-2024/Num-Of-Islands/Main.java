import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    static void dfs(int[][] grid, int[][] vis, int n, int m, int r, int c){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c] == 0 || vis[r][c] == 1) return;
        vis[r][c] = 1;
        // adjcent nodes p travel krna hai
        // adjacent node should be 1
        // up, right, down , left
        dfs(grid, vis, n, m, r, c+1);
        dfs(grid, vis, n, m, r+1, c);
        dfs(grid, vis, n, m, r-1, c);
        dfs(grid, vis, n, m, r, c-1);
        
    }
    static int numberOfIslands(int[][] grid, int n, int m){
        //Write your code here
        int [][] vis = new int[m][n];
        int ct = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    ct++;
                    // dfs call
                    dfs(grid, vis, n, m, i, j);
                }
            }
        }
        return ct;
    }
}

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
        int n = sc.nextInt();
    	int M[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = sc.nextInt();
		    }
		}
		System.out.println(Solution.numberOfIslands(M, m, n));
	}
}
