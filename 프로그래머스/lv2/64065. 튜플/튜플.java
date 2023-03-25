import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        String str = "";
        for(int i = 0; i < s.length(); i++) {
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                if(!(str.equals(""))) {
                    int n = Integer.parseInt(str);
                    if(map.get(n) == null) map.put(n, 1);
                    else map.put(n, map.get(n) + 1);
                }
                str = "";
            }
            else str += s.charAt(i);
        }
        
        int[] answer = new int[map.size()];
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            list.add(map.get(key));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) == entry.getValue()) answer[i] = entry.getKey();
            }
        }
        
        return answer;
    }
}