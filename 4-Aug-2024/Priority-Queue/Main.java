import java.util.*;
import java.lang.*;
import java.io.*;

class Edge{
    int u,v;
    Edge(int x, int y){
        u = x;
        v = y;
    }
    Edge(){
        
    }
}

// comparator
// comparable
// lambda function

public class Main
{

	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
        // min priorityQueue
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq.add(4);pq.add(1);pq.add(3);pq.add(2);
        // for(int i = 0; i<4; i++){
        //     System.out.println(pq.remove());
        // }
        // Max pq
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // pq.add(4);pq.add(1);pq.add(3);pq.add(2);
        // for(int i = 0; i<4; i++){
        //     System.out.println(pq.remove());
        //     System.out.println(pq.peek());
        // }
        // jiski u ki value choti hogi wo edge pehle consider hoga ya small consider hoga
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->(e1.u-e2.u));
        // v jiska small hai wo edge small consider krna hai
        // PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->(e1.v-e2.v));

        // jiska u smaller hai wo greater edge consider krna hai
        // u greater to pehle aaega, u smaller to baad me aaega
        // PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->(e2.u-e1.u));

        // jiska v smaller hai wo greater edge ho
         // PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->(e2.v-e1.v)); // lambda fuhnction is nothing but comparable
        
        
        for(int i = 0; i<1; i++){
            Edge e1 = new Edge(i, i+1);
            pq.add(e1);
        }
        for(int i = 0; i<1; i++){
            System.out.println(pq.peek().u + " " + pq.peek().v);
            pq.remove();
        }
        
	}
}

