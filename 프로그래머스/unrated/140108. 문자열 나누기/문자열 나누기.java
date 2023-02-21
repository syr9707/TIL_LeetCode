import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        char c = s.charAt(0);
        int cntC = 1;
        int cntNext = 0;
        for(int i = 1; i < len; i++) {
            char nextC = s.charAt(i);
            if(cntC == cntNext) {
                answer++;
                c = nextC;
                cntC = 1;
                cntNext = 0;
                continue;
            }
            
            if(c == nextC) cntC++;
            else cntNext++;
        }
        
        return answer + 1;
    }
}