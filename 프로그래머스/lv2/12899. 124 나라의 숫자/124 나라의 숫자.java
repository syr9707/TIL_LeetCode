import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        String[] num = {"4", "1", "2"};
        
        while(n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        
        return answer;
    }
}