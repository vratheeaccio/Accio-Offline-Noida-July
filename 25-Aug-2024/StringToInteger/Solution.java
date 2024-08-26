class Solution {
    public int myAtoi(String s) {
        
        int i = 0, n = s.length();
        // leading white space
        while(i<n && s.charAt(i) ==  ' ') i++;
        boolean neg = false;
        if(i<n && s.charAt(i) == '-') {
            neg = true; i++;
        }
        else if(i<n && s.charAt(i) == '+' ) i++;
        // leading zeroes
        while(i<n && s.charAt(i) ==  '0') i++;
        
        // main algo starts
        // check for first char and store that char in ans with sign
        int ans = 0;
        if(i<n && s.charAt(i)>= '0' && s.charAt(i)<= '9') ans += (s.charAt(i)-'0');
        else return ans;
        i++;
        // check for neg sign
        if(neg) ans *= -1;
        while(i<n ){
            // check for each char '0' <= '9'
            if(s.charAt(i)>= '0' && s.charAt(i) <= '9'){
                // add krna hai inside ans
                if(!neg){
                    if(ans <= Integer.MAX_VALUE/10){
                        ans *= 10;
                        if(ans <= Integer.MAX_VALUE - (s.charAt(i)-'0'))
                            ans += (s.charAt(i)-'0');
                        else{
                            ans = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    else{
                        ans = Integer.MAX_VALUE;
                        break;
                    }
                }
                else{
                    if(ans >= Integer.MIN_VALUE/10){
                        ans *= 10;
                        if(ans >= Integer.MIN_VALUE + (s.charAt(i)-'0'))
                            ans -= (s.charAt(i)-'0');
                        else{
                            ans = Integer.MIN_VALUE;
                            break;
                        }
                    }
                    else{
                        ans = Integer.MIN_VALUE;
                        break;
                    }
                }
                
            }
            else{
                break;
            }
            i++;
        }
        
        return ans;
    }
}
