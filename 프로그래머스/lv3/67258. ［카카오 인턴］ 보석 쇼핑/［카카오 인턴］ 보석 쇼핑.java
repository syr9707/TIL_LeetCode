import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int len = gems.length;
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < len; i++) {
            set.add(gems[i]);
        }
        int total = set.size();
        
        int distance = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        
        int start = 0;
        int end = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        while(true) {
            if(total == map.size()) {
                map.put(gems[left], map.get(gems[left]) - 1);
                
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if(right == len) break;
            else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            
            if (map.size() == set.size()) {
                if (right-left < distance){
                    distance = right-left;
                    start = left+1;
                    end = right;
                }
            }
        }
        
        answer[0] = start;
        answer[1] = end;
        
        return answer;
    }
}