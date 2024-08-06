import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

    
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here

        // edges  list --> edg --> E values --> (u,v) --> Arraylist<ArrayList<Integer>>
        // ArrayList<Pair<Integer, Integer>> edg
        int E = 4, V = 4;
        ArrayList<ArrayList<Integer>> edg = new ArrayList<>();
        // for(int i = 0; i<E; i++){
        //     int 
        // }
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1); tmp.add(2);
        edg.add(tmp);
        ArrayList<Integer> tmp1 = new ArrayList<>();
        tmp1.add(1); tmp1.add(3);
        edg.add(tmp1);
        ArrayList<Integer> tmp2 = new ArrayList<>();
        tmp2.add(2); tmp2.add(4);
        edg.add(tmp2);
        ArrayList<Integer> tmp3 = new ArrayList<>();
        tmp3.add(3); tmp3.add(4);
        edg.add(tmp3);

        // adj list
        // E --> edges ,  V --> vertices , --> 0/1 --> based indexing

        //  adj --> Arraylist<Arraylist<Integer>> adj
        //

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // 1based indexing
        for(int i = 0; i<=V; i++) adj.add(new ArrayList<Integer>());
        // adj list bnaenge
        for(int i = 0; i<E; i++){
            int u = edg.get(i).get(0);
            int v = edg.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // adj list print
        for(int i = 0; i<=V; i++){
            for(int j = 0; j<adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
        
        
        
	}
}

