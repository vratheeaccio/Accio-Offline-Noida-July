import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair{
    Node par;
    int lr, rr;
    Pair(Node n, int l, int r){
        par = n; lr = l; rr = r;
    }
    Pair(){
        
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {
    Node bstFromLevel(int arr[], int n) {
        // write code here
        Node root = new Node(arr[0]);
        // queue will store --> par, lr, rr
        Queue<Pair> q = new LinkedList<>();
        // left child cand
        q.add(new Pair(root, Integer.MIN_VALUE, root.data));
        // right child cand
        q.add(new Pair(root, root.data, Integer.MAX_VALUE));
        int ind = 1;
        while(!q.isEmpty() && ind<n){
            Pair tmp = q.remove();
            // whether this tmp cand fulfills arr[ind]
            if(arr[ind]>tmp.lr && arr[ind] < tmp.rr){
                // figure out lc ya rc
                if(tmp.par.data > arr[ind]){
                    // left child
                    Node lc = new Node(arr[ind]);
                    tmp.par.left = lc;
                    q.add(new Pair(lc, tmp.lr, lc.data));
                    q.add(new Pair(lc, lc.data, tmp.par.data));
                }
                else{
                    //right child
                    Node rc = new Node(arr[ind]);
                    tmp.par.right = rc;
                    q.add(new Pair(rc, tmp.par.data, rc.data));
                    q.add(new Pair(rc, rc.data, tmp.rr));
                }
                ind++;
            }
        }
        return root;
        
    }
}
