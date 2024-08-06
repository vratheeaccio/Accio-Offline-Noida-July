import java.io.*;
import java.util.*;
import java.lang.*;

class Edge{
    int v, dis;
    Edge(int x, int d){
        v = x; dis = d;
    }
    Edge(){
        
    }
}

public class Main {
  public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
  {
     // Write your code here
      // min dis k according
      PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> (e1.dis-e2.dis));
      pq.add(new Edge(S, 0));
      int [] vis = new int[V];
      // rest dis -> inf
      // source dis -> 0
      for(int i = 0; i<V; i++) vis[i] = 9999999;
      vis[S] = 0;
      while(!pq.isEmpty()){ //O(2nlogn) + O(2Elogn)
          Edge e1 = pq.remove(); //O(logn)
          // if this is already vis --> skip
          if(e1.v != S &&  vis[e1.v] != 9999999) continue;
          vis[e1.v] = e1.dis;
          for(ArrayList<Integer> a : adj.get(e1.v)){
              int u = a.get(0);
              int wt = a.get(1);
              if(vis[u] == 9999999){
                  pq.add(new Edge(u, e1.dis + wt)); //O(logn)
              }
          }
      }
      for(int i = 0; i<V; i++){
          if(vis[i] == 9999999) vis[i] = -1;
      }
      return vis;

      // O(ElogV ) // Sc --> O(V)
      
       
  }

  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}

