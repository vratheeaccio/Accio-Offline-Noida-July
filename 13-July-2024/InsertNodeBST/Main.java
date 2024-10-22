import java.util.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

class BST {
    Node root;

    private Node insertHelper(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.val) {
            root.left = insertHelper(root.left, value);
        } else {
            root.right = insertHelper(root.right, value);
        }

        return root;
    }

    BST() {
        root = null;
    }

    // Function to insert a value into the BST
    void insert(int value) {
        root = insertHelper(root, value);
    }
}

public class Main {
   
   static void preOrderTraversalHelper(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraversalHelper(root.left);
            preOrderTraversalHelper(root.right);
        }
    } 
   
    static public Node InsertNode(Node root, int value) {
           // write your code here
        Node cur = root, prev = null;
        while(cur!=null){
            if(cur.val < value){
                prev = cur;
                cur = cur.right;
            }
            else{
                prev = cur;
                cur = cur.left;
            }
        }
        cur = new Node(value);
        if(prev.val > value){
            prev.left = cur;
        }
        else prev.right = cur;
        return root;
    }


    public static void main(String[] args) {
        BST bst = new BST();
        int totalNodes = 0;

        Scanner scanner = new Scanner(System.in);
        totalNodes = scanner.nextInt();

        for (int i = 0; i < totalNodes; i++) {
            int val = scanner.nextInt();
            bst.insert(val);
        }

        int key = scanner.nextInt();
        bst.root = InsertNode(bst.root  , key);  // Inserting the new node

        preOrderTraversalHelper(bst.root); // Perform pre-order traversal
        scanner.close();
    }
}

