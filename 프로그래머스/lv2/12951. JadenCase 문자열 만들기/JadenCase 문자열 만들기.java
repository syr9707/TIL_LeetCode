import java.util.*;

class Solution {
    public String solution(String s) {
        String answer;
        
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z') answer = String.valueOf(s.charAt(0)).toUpperCase();
        else answer = String.valueOf(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            if(i != s.length() - 1) {
                if(String.valueOf(s.charAt(i)).equals(" ") && !(String.valueOf(s.charAt(i + 1)).equals(" "))) {
                    answer += String.valueOf(s.charAt(i));
                    answer += String.valueOf(s.charAt(i + 1)).toUpperCase();
                    i = i + 1;
                }
                else {
                    answer += String.valueOf(s.charAt(i)).toLowerCase();
                }
            }
            else answer += String.valueOf(s.charAt(i)).toLowerCase();
        }
        
        return answer;
    }
}