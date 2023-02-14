import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int len = choices.length;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            if(choices[i] >= 5) {
                char c = survey[i].charAt(1);
                map.put(c, map.getOrDefault(c, 0) + choices[i] - 4);
            } else if(choices[i] <= 3) {
                char c = survey[i].charAt(0);
                map.put(c, map.getOrDefault(c, 0) + 4 - choices[i]);
            }
        }
        
        if(map.get('R') == null) map.put('R', 0);
        if(map.get('T') == null) map.put('T', 0);
        if(map.get('C') == null) map.put('C', 0);
        if(map.get('F') == null) map.put('F', 0);
        if(map.get('J') == null) map.put('J', 0);
        if(map.get('M') == null) map.put('M', 0);
        if(map.get('A') == null) map.put('A', 0);
        if(map.get('N') == null) map.put('N', 0);
        
        if(map.get('R') >= map.get('T')) answer += "R";
        else answer += "T";
        
        if(map.get('C') >= map.get('F')) answer += "C";
        else answer += "F";
        
        if(map.get('J') >= map.get('M')) answer += "J";
        else answer += "M";
        
        if(map.get('A') >= map.get('N')) answer += "A";
        else answer += "N";
        
        return answer;
    }
}