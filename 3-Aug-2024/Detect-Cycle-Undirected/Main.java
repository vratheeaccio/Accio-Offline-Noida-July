import java.io.*;
import java.util.*;

class Solution {
    // if cycle exists --> true
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int parent){
        // visit this node
        vis[node] = 1;
        // System.out.print(node + " ");
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
              if(dfs(adj, it, vis, node)) return true;  
            } 
            else {
                if(it != parent) return true; //cycle hai
            }
        }
        return false;
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       // Your code here
        int [] vis = new int[V];
        for(int i = 0; i<V; i++){
            if(vis[i] == 0 ) if(dfs(adj, i, vis, -1) == true) return true;
        }
        return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
