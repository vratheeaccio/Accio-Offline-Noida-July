class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String t1 = strs[0], t2 = strs[strs.length - 1];
        // compare t1 and t2
        // char ch = ' ';
        String ans = "";
        for(int i = 0; i<t1.length(); i++){
            if(t1.charAt(i) != t2.charAt(i)) return ans;
            ans += t1.charAt(i);
        }
        return ans;

    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        char ch = ' ';
        int indexCheck = 0;
        while(true){
            if(strs[0].length() <= indexCheck){
                return ans;
            }
            ch = strs[0].charAt(indexCheck);
            for(int i = 1; i<strs.length; i++){
                if(strs[i].length() <= indexCheck || strs[i].charAt(indexCheck) != ch){
                    return ans;
                }
            }
            ans += ch;
            indexCheck++;
        }
        // return ans;

    }
}
