import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class ItemComp implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        // value / kg of i1
        double i1vpkg = (i1.value*1.0)/(i1.weight*1.0);
        double i2vpkg = (i2.value*1.0)/(i2.weight*1.0);
        // if value per kg of i1 is smaller and we want i2 to come first
        // return (int)(i2vpkg - i1vpkg);
        if(i1vpkg < i2vpkg) return 1;
        return -1; // for natural order
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
       // Write your code here
       // i1 is having less valu/weight we want i2 to come first
       Arrays.sort(arr, new ItemComp());
       double ans = 0;
       int wt = 0; // weight taken so far 
       for(int i = 0; i<n; i++){
            // if wt+arr[i].weight <= w
            if( wt + arr[i].weight > W){
                // take fraction and break
                // (W-wt) * that items value per kg
                ans += (W-wt) * ((arr[i].value * 1.0)/arr[i].weight);
                break;
            }
            // take comp item
            ans += arr[i].value;
            wt += arr[i].weight;
       }
       return ans;


    }
}
