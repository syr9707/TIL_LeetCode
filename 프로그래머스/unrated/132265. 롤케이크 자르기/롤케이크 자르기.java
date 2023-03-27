import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        
        HashSet<Integer> left = new HashSet<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for(int i = 1; i < len; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        left.add(topping[0]);
        for(int i = 1; i < len - 1; i++) {
            left.add(topping[i]);
            right.put(topping[i], right.get(topping[i]) - 1);
            if(right.get(topping[i]) == 0) {
                right.remove(topping[i]);
            }
            
            if(left.size() == right.size()) answer++;
        }
        
        return answer;
    }
}