import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n)
    {
        // Your code here
        // a is smaller profit job than b and we want b first
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        // occupied
        int [] occupied = new int[n+1];
        int ct = 0, totPr = 0;
        for(int i = 0; i<arr.length; i++){
            // we try to do this job on its deadline
            int dl = arr[i].deadline;
            // if occupied[dl] != 0
            while(dl > 0 && occupied[dl] != 0) dl--;
            if(dl != 0){
                occupied[dl] = arr[i].profit;
                totPr += arr[i].profit;
                ct++;
            }
        }
        return new int[]{ct, totPr};

    }
}

