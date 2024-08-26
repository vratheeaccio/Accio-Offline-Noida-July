import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Huffman{
    int data;
    char ch;
    Huffman left,  right;
    Huffman(int d, char c){
        data = d; ch = c;
        left = null; right = null;
    }
    Huffman(){

    }
}

class HuffmanCom implements Comparator<Huffman>{
    public int compare(Huffman h1, Huffman h2){
        if(h1.data < h2.data) return h1.data-h2.data;
        return 1;
    }
}

class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        // make huffman tree
        // huffman tree 
        // take two chars with lowest freq --> assign them a parent
        // parents value will be nothing but sum of their freq
        // ascneding order
        PriorityQueue<Huffman> pq = new PriorityQueue<>(new HuffmanCom());
        for(int i = 0; i<N; i++){
            Huffman hf = new Huffman(f[i], S.charAt(i));
            pq.add(hf);
        }

        while(pq.size()>1){
            Huffman h1 = pq.remove();
            Huffman h2 = pq.remove();
            Huffman par = new Huffman(h1.data + h2.data, '-');
            par.left = h1;
            par.right = h2;
            pq.add(par);
        }
        // tree is formed
        // pq has root of the tree

        ArrayList<String> ans = new ArrayList<>();
        preOrder(pq.remove(), ans, ""); // root left and right
        // left --> 0 , right --> 1
        return ans;
    }
    public void preOrder(Huffman root, ArrayList<String> ans, String tmp){
        if(root == null) return ;
        // if it is a leaf node then add its path to ans
        if(root.left == null && root.right == null){
            ans.add(tmp);
            return;
        }
        preOrder(root.left, ans, tmp+"0");
        preOrder(root.right, ans, tmp+"1");
    }
    
}
