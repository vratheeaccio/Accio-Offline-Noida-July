import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int canFinish(int n, int[][] p) {
        //write your code here
        // edge list is given
        // create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        int [] indeg = new int[n];
        // fill adj list
        for(int i = 0; i<p.length; i++){
            int u = p[i][0];
            int v = p[i][1];
            // edge is from v --> u
            adj.get(v).add(u);
            // fill indegree
            indeg[u]++; // u is having incoming edge
        }
        // ans --> topo sort
        // bfs --> queue and vis
        // int [] vis = new int[n]; // never required
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indeg[i] == 0){
                // it can be the first node
                q.add(i);
            }
        }
        // bfs starts
        while(!q.isEmpty()){
            int node = q.remove();
            // this node is having indeg 0
            ans.add(node);
            // we will remove this node
            // travel in adj of this node and reduce indeg of each adjacent node of this node by 1
            for(Integer it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
        }
        // here we will have topo sort stored in ans
        if(ans.size() < n) {
            // no topological order exists
            // cycle is there in directed graph
            return 0;
        }
        return 1;

        

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}
