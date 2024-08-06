import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean dfs(ArrayList<Integer>[] adj, int [] vis, int [] pvis, int node, int par){
        vis[node] = 1;
        pvis[node] = 1;
        for(Integer it : adj[node]){
            if(vis[it] == 0){
                if(dfs(adj, vis, pvis, it, node)) return true;
            }
            else{
                // pvis hai and parent k equal nahi hai --> true
                if(pvis[it] == 1 && it != par) return true;
            }
        }
        pvis[node] = 0;
        return false;
    }
public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
    // Your code here
    int [] vis = new int[V+1];
    int [] pvis = new int[V+1];
    for(int i = 0; i<V; i++){
        if(dfs(adj, vis, pvis, i, -1)) return true;
    }
    return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
