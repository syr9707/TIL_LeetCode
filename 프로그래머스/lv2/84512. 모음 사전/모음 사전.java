import java.util.*;

class Solution {
    public int solution(String word) {
        //nt answer = 0;
        
        int answer = word.length();
        
        String str = "AEIOU";
        int[] x = {781, 156, 31, 6, 1};
        
        for (int i = 0; i < word.length(); i++) {
            int idx = str.indexOf(word.charAt(i));
            answer += x[i] * idx;
        }
        
        return answer;
    }
}