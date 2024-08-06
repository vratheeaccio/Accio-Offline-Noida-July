import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static TreeNode prev = null, f = null, m = null, l = null;
    public static void Inorder(TreeNode root){
        if(root == null) return ;
        Inorder(root.left);
        if(prev != null){
            if(prev.val > root.val){
                if(f == null){
                    f = prev;
                    m = root;
                }
                else{
                    l = root;
                }
            }
        }
        prev = root;
        Inorder(root.right);
    }

    public static void recoverTree(TreeNode root) {
        //Write code here
        Inorder(root);
        if(l == null){
            int tmp = m.val;
            m.val = f.val;
            f.val = tmp;
        }
        else{
            int tmp = l.val;
            l.val = f.val;
            f.val = tmp;
        }
        
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
