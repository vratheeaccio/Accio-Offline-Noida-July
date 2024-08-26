import java.util.*;
import java.io.*;
import java.util.*;
class Solution{
    public static ArrayList<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> adj){
        //write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min type
        int [] indeg = new int[V+1];
        for(int i = 1; i<=V; i++){
            for(Integer it : adj.get(i)){
                // node indeg ++;
                indeg[it]++;
            }
        }
        for(int i = 1; i<=V; i++){
            if(indeg[i] == 0) pq.add(i);
        }
        if(pq.size() == 0){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(-1);
            return tmp;
        }
        // bfs
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            int node = pq.remove();
            ans.add(node);
            // travel in adj of node
            for(Integer it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) pq.add(it);
            }
            // sort that temp array
            // push all values in q
        }
        // topological sort has v entries or not, if not V entries return -1
        // else return topo sort
        if(ans.size() < V){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(-1);
            return tmp;
        }
        return ans; 
    }
}
public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = Integer.parseInt(sc.next());
        int E = Integer.parseInt(sc.next());
        for(int i = 0 ; i <= V ; ++i){
            adj.add(i , new ArrayList<Integer>());
        }
        for(int i = 0 ; i < E ; ++i){
            int u = Integer.parseInt(sc.next());
            int v = Integer.parseInt(sc.next());
            adj.get(u).add(v); 
        }
        Solution ob = new Solution();
        ArrayList<Integer> ans = ob.topologicalSort(V,adj);
        for(int i = 0 ; i < ans.size() ; ++i){
            System.out.print(ans.get(i) + " ");
        }
    }
}
