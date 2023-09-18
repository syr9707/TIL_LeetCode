import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            String str = babbling[i];
            
            str = str.replaceAll("aya", "1");
            str = str.replaceAll("ye", "1");
            str = str.replaceAll("woo", "1");
            str = str.replaceAll("ma", "1");
            
            str = str.replaceAll("1", "");
            if(str.equals("")) answer++;
        }
        
        return answer;
    }
}