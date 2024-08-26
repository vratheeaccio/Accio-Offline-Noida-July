class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i = 0; i<s.length() ; i++){
            char ch = s.charAt(i);
            if( (ch >= 'A' && ch <= 'Z') || (ch>='a' && ch<='z') || (ch >= '0' && ch<='9') ){
                // check for capital letter
                if(ch >= 'A' && ch <= 'Z'){
                    int dist = ch - 'A';
                    str += (char)((int)'a' + dist);
                }
                else str += ch;
            }
        }
        // check for palindrome
        int l = 0, r = str.length()-1;
        while(l<r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
