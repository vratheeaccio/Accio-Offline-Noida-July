import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
		// write code here
        int [] f1 = new int [60]; // frq for t
        int [] f2 = new int [60]; // frq for substr of s
        // fill f1 with t
        for(int i = 0; i<t.length(); i++) f1[(int)(t.charAt(i) - 'A')]++;
        for(int i = 0; i<t.length()-1; i++) {
            f2[(int)(s.charAt(i) - 'A')]++;
        }
        int j = t.length()-1, i = 0, anslen = Integer.MAX_VALUE;
        String ans = "";
        while(j<s.length()){
            f2[(int)(s.charAt(j)-'A')]++;
            boolean flag = true;
            for(int k = 0; k<60; k++){
                if(f1[k] != 0 && f1[k] > f2[k]) flag = false;
            }
            while(flag){
                if(anslen > j-i+1){
                        anslen = j-i+1;
                        ans = s.substring(i, i+anslen);
                }
                f2[(int)(s.charAt(i)-'A')]--;
                if(f1[(int)(s.charAt(i)-'A')] > f2[(int)(s.charAt(i)-'A')]) flag = false;
                i++;
            }
            j++;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}
