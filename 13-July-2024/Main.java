import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(){
        
    }
    Node(int val){
        this.val = val;
    }
}

public class Main
{
    public static Node buildBST(int arr[], int l, int r){
        // code
        //base case
        if(l>r) return null;
        int m = (l+r)/2;
        Node root = new Node(arr[m]);
        root.left = buildBST(arr, l, m-1);
        root.right = buildBST(arr, m+1, r);
        return root;
    }
    public static void printBST(Node root){
        
        if(root == null) return;
        printBST(root.left);
        System.out.print(root.val + " ");
        printBST(root.right);
        
    
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here 
        int [] arr = new int[5];
        for(int i = 0; i<5; i++) arr[i] = i+1;
        Node root = buildBST(arr, 0, 4);
        printBST(root);
	}
}
