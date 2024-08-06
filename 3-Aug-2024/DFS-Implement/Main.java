import java.util.*;

class Solution {
    // O(n) + O(2E) --> TC --> O(V+E)
    // sc --> O(V)
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] vis){
        // visit this node
        vis[node] = 1;
        System.out.print(node + " ");
        for(Integer it : adj.get(node)){
            if(vis[it] == 0) dfs(adj, it, vis);
        }
    }
    // O(V + ELogE) --> TC
    // O(V+E) --> SC
    public static void DFSTraversal(List<List<Integer>> edg, int n) {
        //Write your code here
        // first create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // O(2E)
        for(int i = 0; i<n; i++) adj.add(new ArrayList<Integer>()); //O(N)
        int E = edg.size();
        for(int i = 0; i<E; i++){ // O(E)
            int u = edg.get(i).get(0);
            int v = edg.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // sorting adj list of each node
        for(int i = 0; i<n; i++) Collections.sort(adj.get(i)); //O(N) + O(ElogE)
        // main dfs start
        int [] vis = new int[n]; //O(N)
        dfs(adj, 0, vis);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}
