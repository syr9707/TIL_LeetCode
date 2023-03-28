import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        
        for(int i = 1; i <= len / 2; i++) {
            int zipLevel = 1;
            String zipStr = s.substring(0, i);
            StringBuilder result = new StringBuilder();
            
            for(int j = i; j <= len; j += i) {
                String nextStr = s.substring(j, j + i > s.length() ? s.length() : j + i);
                if(zipStr.equals(nextStr)) zipLevel++;
                else {
                    result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
                    zipStr = nextStr;
                    zipLevel = 1;
                }
            }
            result.append(zipStr);
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}