import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        int startIndex = 0;
        int answer = 0;
        int n = s.length();
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                startIndex = Math.max(startIndex, map.get(c) + 1);
            }
            map.put(c, i);
            answer = Math.max(answer, i - startIndex + 1);
        }
        
        return answer;
        
    }
}