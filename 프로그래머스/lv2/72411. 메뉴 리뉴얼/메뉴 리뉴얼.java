import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map;
    static int max = 0;
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> list = new ArrayList<>();
        for(int c : course) {
            map = new HashMap<>();
            max = 0;
            
            for(String order : orders) {
                char[] strs = order.toCharArray();
                Arrays.sort(strs);
                order = new String(strs);
                checkOrder(0, -1, order, "", c);
            }
            
            for(String key : map.keySet()) {
                int value = map.get(key);
                if(value > 1 && max == value) list.add(key);
            }
        }
        
        Collections.sort(list);
        String[] answer = list.toArray(new String[list.size()]);
        
        return answer;
    }
    
    public void checkOrder(int stage, int pidx, String order, String cur, int end) {
        if(stage == end) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            max = Math.max(max, map.get(cur));
        }
        
        for(int i = pidx + 1; i < order.length(); i++) {
            checkOrder(stage + 1, i, order, cur + order.charAt(i), end);
        }
    }
}