import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for(int i = len; i > 0; i--) {
            for(int j = 0; j + i <= len; j++) {
                if(isPalindrome(s, j, j + i - 1)) return i;
            }
        }
        
        return answer;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        
        return true;
    }
}