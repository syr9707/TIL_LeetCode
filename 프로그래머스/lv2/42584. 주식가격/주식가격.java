import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < prices.length; i++) {
            q.add(prices[i]);
        }
        
        for(int i = 0; i < prices.length; i++) {
            int num = prices[i];
            boolean flag = false;
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] - num < 0) {
                    answer[i] = j - i;
                    flag = true;
                    break;
                }
            }
            if(flag == false) answer[i] = prices.length - i - 1;
        }
        
        return answer;
    }
}