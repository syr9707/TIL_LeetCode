import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {
        
        List<Long> answer = new ArrayList<>();
        
        for(long i = left; i <= right; i++) {
            answer.add(Math.max(i / n, i % n) + 1);
        }
        
        return answer;
    }
}