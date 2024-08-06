import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int mat[][], Pair q[]) {
        // Your code here
        int n = mat.length, m = mat[0].length;
        int [][] pref = new int[n][m];
        // fill pref matrix
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int v1 = 0; // upper rectangle
                if(i-1>=0) v1 = pref[i-1][j];
                int v2 = 0; // left rect
                if(j-1>=0) v2 = pref[i][j-1];
                int v3 = 0; // corner rec
                if(i-1>=0 && j-1>=0) v3 = pref[i-1][j-1];
                pref[i][j] = v1 + v2 - v3 + mat[i][j];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Pair p : q){
            int r1 = p.row1, c1 = p.col1, r2 = p.row2, c2 = p.col2;
            int v1 = 0;
            if(c1-1>=0) v1 = pref[r2][c1-1];
            int v2 = 0;
            if(r1-1>=0) v2 = pref[r1-1][c2];
            int v3 = 0;
            if(r1-1>=0 && c1-1>=0) v3 = pref[r1-1][c1-1];
            ans.add(pref[r2][c2] + v3 - v1 - v2);
        }
        return ans;
        
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}
