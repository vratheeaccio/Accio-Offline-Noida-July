import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
        int n = A.length;
        int [] pr = new int[n];
        for(int i = 0; i<ops.length; i++){
            int l = ops[i][0];
            int r = ops[i][1];
            pr[l]++;
            if(r<n-1) pr[r+1]--;
        }
        // take prefix sum of partial array
        for(int i = 1; i<n; i++) pr[i] += pr[i-1];
        // sort both pref arrays and A array
        Arrays.sort(pr);
        Arrays.sort(A);
        int mod = (int)1e9 + 7;
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans = (ans + A[i]*pr[i])%mod;
        }
        return ans;
        
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}




