import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int r, c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
    Pair(){
        
    }    
}

public class Main {
	
	  public static void main (String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int [][] arr= new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                arr[i][j]=sc.nextInt();
	            }
	        }
	        Solution obj= new Solution();
	        
	        System.out.println(obj.orangesRotting(arr));
		}
}
class Solution{        
	 public static int orangesRotting(int[][] grid) {
//your code
    // make queue
         Queue<Pair> q = new LinkedList<>();
         int n = grid.length, m = grid[0].length;
         int ct = 0, t = 0; //fresh oranges
         for(int i = 0; i<n; i++){
             for(int j = 0; j<m; j++){
                 // all sources push into q
                 if(grid[i][j] == 2) q.add(new Pair(i, j));
                 if(grid[i][j] == 1) ct++;
             }
         } 
         if(ct == 0) return 0;
         // bfs
        while(!q.isEmpty()){
            int sz = q.size();
            t++;
            for(int i = 0; i<sz; i++){
                Pair p = q.remove();
                int r = p.r, c = p.c;
                // 4 directions adj check krenge
                int [] dx = {1, 0, -1, 0};
                int [] dy = {0, 1, 0, -1};
                for(int j = 0; j<4; j++){
                    int nc = c + dx[j];
                    int nr = r + dy[j];
                    // if nr,nc is not vis and fresh orange
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        ct--;
                        q.add(new Pair(nr, nc));
                    }
                }
            }
            // if(!q.isEmpty())t++;
        }
         // traverse the grid if any cell found to be 1 return -1
         if(ct!=0) return -1;
         return t-1; 
         
 }
}

