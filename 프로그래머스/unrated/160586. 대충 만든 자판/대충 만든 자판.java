import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(String s : keymap) {
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(map.get(c) == null) {
                    map.put(c, i + 1);
                } else {
                    map.put(c, Math.min(i + 1, map.get(c)));
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if(map.get(c) == null) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(c);
            }
        }
        
        return answer;
    }
}