import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int [] pvis, int N, int ct, int snode){
        pvis[node] = 1; ct++;
        if(ct == N){
            // for(Integer it : adj.get(node)){
            //     if(it == snode){
            //         System.out.println("Hamiltonian Cycle");
            //     }
            // }
            return true;
        } 
        // travel in adj
        for(Integer it : adj.get(node)){
            if(pvis[it] == 0){
                // call dfs
                // if dfs return true --> path exists
                if(dfs(adj, it, pvis, N, ct, snode)) return true;
            }
        }
        pvis[node] = 0;
        // ct--;
        return false;
    }
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
        // create adj list 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=N; i++) adj.add(new ArrayList<>());
        // fill adj list
        for(int i = 0; i<M; i++){
            int u = Edges.get(i).get(0);
            int v = Edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // pvis
        int [] pvis = new int[N+1];

        // call dfs or make all possible paths from each of the nodes
        // if any of the node does contain a path that visits N node --> true
        for(int i = 1; i<=N; i++){
            // N --> no of total nodes to visit
            // 0 --> no of nodes visited so far
            if(dfs(adj, i, pvis, N, 0, i)) return true;
        }
        return false;

    
    }
}
