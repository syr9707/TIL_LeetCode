import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int len = ingredient.length;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            int size = list.size();
            if(size < 3) {
                list.add(ingredient[i]);
                continue;
            }
            
            if(ingredient[i] == 1) {
                if(list.get(size - 1) == 3 && list.get(size - 2) == 2 && list.get(size - 3) == 1) {
                    answer++;
                    list.subList(size - 3, size).clear();
                } else {
                    list.add(ingredient[i]);
                }
            } else list.add(ingredient[i]);
        }
        
        return answer;
    }
}