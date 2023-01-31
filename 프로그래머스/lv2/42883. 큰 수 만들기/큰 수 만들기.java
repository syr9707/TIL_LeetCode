import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int len = number.length() - k;
        int start = 0;
        int numLen = number.length();
        
        StringBuilder answer = new StringBuilder("");
        
        while(start < numLen && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for(int i = start; i < leftNum; i++) {
                if(max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    start = i + 1;
                }
            }
            answer.append(Integer.toString(max));
        }
        
        return answer.toString();
    }
}