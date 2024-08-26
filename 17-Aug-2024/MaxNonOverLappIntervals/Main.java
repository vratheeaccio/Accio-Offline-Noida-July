import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
    // sort array a according to finsh time --> 1st index
    // assuming a is smaller than b and we want a tocome first

        Collections.sort(A, (a, b) -> (a.get(1)-b.get(1)));
        int ct = 0, endtim = 0;
        for(int i = 0; i<A.size(); i++){
            // cur index st time should be greater then prev endtim
            if(A.get(i).get(0) > endtim){
                ct++;
                endtim = A.get(i).get(1);
            }
        }
        return ct;

	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}

