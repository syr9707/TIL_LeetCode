import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String str = "";
        int num = 0;
        while(true) {
            str += Integer.toString(num, n);
            num++;
            if(str.length() >= m * t) break;
        }
        
        for(int i = 0; i < t; i++) {
            answer += String.valueOf(str.charAt(i * m + (p - 1))).toUpperCase();
        }
        
        return answer;
    }
    
}