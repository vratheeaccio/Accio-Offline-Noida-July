import java.util.*;

class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int [] vis, int col){
        vis[node] = col;
        // travel in adj of node
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                // visit this node
                if(dfs(adj, it, vis, -1*col ) == false) return false;
            }
            else{
                // it is visited
                // if `it` is visited with same color as node
                if(vis[it] == vis[node]) return false;
            }
        }
        return true;
    }
   
   // TC --> O(V+E);
   // SC --> O(V+E);
    public int possibleBipartition(int n, int[][] dislikes) {
        // Write your code here
        // edge list given in form of dislikes
        // create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());
        // fill adj list
        for(int i = 0; i<dislikes.length; i++){
            int u = dislikes[i][0], v = dislikes[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] vis = new int[n+1];
        // if(dfs(adj, 1, vis, 1)) return 1;
        // return 0;
        for(int i = 1; i<=n; i++){
            if(vis[i] == 0){
                if(dfs(adj, i, vis, 1) == false) return 0;
            }
        }
        return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
