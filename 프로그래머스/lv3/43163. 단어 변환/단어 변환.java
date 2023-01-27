import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] check;
    
    public int solution(String begin, String target, String[] words) {
        
        check = new boolean[words.length];
        int count = 0;
        dfs(count, begin, target, words);
        
        return answer;
    }
    
    public static void dfs(int count, String begin, String target, String[] words) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(check[i]) continue;
            
            int k = 0;
            for(int j = 0; j < words[i].length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }
            
            if(k == begin.length() - 1) {
                check[i] = true;
                System.out.println(words[i]);
                dfs(count + 1, words[i], target, words);
                check[i] = false;
            }
        }
    }
    
}