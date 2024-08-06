import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // write code here
        int n = words.length;
        HashMap<String, Integer> wordMp = new HashMap<>();
        // putting all words into hashmap
        for(int i = 0; i<n; i++){
            wordMp.put(words[i], wordMp.getOrDefault(words[i], 0) + 1);
        }
        int wrdlen = words[0].length();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i< s.length() - n*wrdlen  ; i++){
            // making first word and checking into wrdmp
            // String tmpWrd = s.substring(i, i+wrdlen);
            // if(wordMp.containsKey(tmpWrd)){
            //     // check next word, --> next word
            // }
            // we wish to find n words
            HashMap<String, Integer> seenMp = new HashMap<>();
            for(int j = 0; j<n; j++){
                String tmpWrd = s.substring(i + j*wrdlen , i+ (j+1)*wrdlen);
                // putting freq of word we just made into seen map
                seenMp.put(tmpWrd, seenMp.getOrDefault(tmpWrd, 0) + 1);
                if(!wordMp.containsKey(tmpWrd)) break;
            }
            //if all the freqs of wrd map equals all the freq of seen map then
            // we can say found a concat
            boolean flag = true;
            for(String wrd : wordMp.keySet()){
                if( !seenMp.containsKey(wrd) ||  wordMp.get(wrd) != seenMp.get(wrd)){
                    flag = false;
                    break;
                }
            }
            if(flag) ans.add(i);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}

