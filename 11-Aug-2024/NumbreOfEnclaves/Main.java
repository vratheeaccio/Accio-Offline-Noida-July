import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }
  public static void dfs(int[][] grid, int[][] vis, int n, int m, int r, int c){
    if(r<0 || c<0 || r>=n || c>=m || grid[r][c] == 0 || vis[r][c] == 1) return;
    vis[r][c] = 1;
    // travel in addj of r,c
    // r,c+1, (r+1,c), (r,c-1), (r-1,c)
    dfs(grid, vis, n, m, r, c+1);
    dfs(grid, vis, n, m, r+1, c);
    dfs(grid, vis, n, m, r, c-1);
    dfs(grid, vis, n, m, r-1, c);
  }

  public static int numEnclaves(int[][] grid) {
    // your code here
    int n = grid.length, m = grid[0].length;
    // vis grid to mark 1s
    int [][] vis = new int[n][m];
    // run dfs for all the boundary 1s
    // for 0th row and n-1st row
    for(int i = 0 ; i<m ; i++ ){
      if(grid[0][i] == 1 && vis[0][i] == 0){
        dfs(grid, vis, n, m, 0, i);
      }
      // last row
      if(grid[n-1][i] == 1 && vis[n-1][i] == 0){
        dfs(grid, vis, n, m, n-1, i);
      }
    }
    // for 0th col and m-1st col
    for(int i = 0 ; i<n ; i++ ){
      if(grid[i][0] == 1 && vis[i][0] == 0){
        dfs(grid, vis, n, m, i, 0);
      }
      // last col
      if(grid[i][m-1] == 1 && vis[i][m-1] == 0){
        dfs(grid, vis, n, m, i, m-1);
      }
    }
    // iterate in ans and grid
    // check for unmarked 1s
    int ct = 0;
    for(int i = 0; i<n; i++){
      for(int j = 0; j<m; j++){
        if( grid[i][j] == 1 && vis[i][j] == 0 ) ct++;
      }
    }
    return ct;
  }
}
