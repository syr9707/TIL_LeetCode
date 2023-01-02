import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            if(map.get(tangerine[i]) == null) map.put(tangerine[i], 1);
            else map.put(tangerine[i], map.get(tangerine[i]) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            answer++;
            if(k <= 0) break;
        }
        
        return answer;
    }
}