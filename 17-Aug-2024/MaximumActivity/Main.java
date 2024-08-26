import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputLine[] = br.readLine().trim().split(" ");
        //size of array
        int n = Integer.parseInt(inputLine[0]);
        int start[] = new int[n];
        int end[] = new int[n];
        
        //adding elements to arrays start and end
        inputLine = br.readLine().trim().split(" ");
        for(int i = 0; i < n; i++)
            start[i] = Integer.parseInt(inputLine[i]);
        
        inputLine = br.readLine().trim().split(" ");
        for(int i= 0; i < n; i++)
            end[i] = Integer.parseInt(inputLine[i]);
        
        System.out.println(new Solution().solve(start, end, n));
    
    }
}

class Solution
{
    
    public static int solve(int start[], int end[], int n)
    {
        // add your code here
        int [][] act = new int[n][2];
        for(int i = 0; i<n; i++){
            act[i][0] = start[i]; // st time
            act[i][1] = end[i]; // end time
        }
        // sort according to end time
        Arrays.sort(act, (a, b) -> (a[1]-b[1]));
        int ct = 0, endtime = 0;
        for(int i = 0; i<n; i++){
            if(act[i][0] > endtime){
                ct++;
                endtime = act[i][1];
            }
        }
        return ct;
    }
}
