import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            answer[i] = players[i];
        }
        
        for(int i = 0; i < callings.length; i++) {
            int order = map.get(callings[i]);
            String now = callings[i];
            String pre = answer[order - 1];
            
            answer[order] = pre;
            answer[order - 1] = now;
            
            map.put(now, order - 1);
            map.put(pre, order);
        }
        
        return answer;
    }
}