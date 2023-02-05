import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < len; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        
        int count = 0;
        while(sum1 != sum2) {
            if(count > len * 3) return -1;
            count++;
            
            int currNum = -1;
            if(sum1 > sum2) {
                currNum = q1.poll();
                q2.offer(currNum);
                sum1 -= currNum;
                sum2 += currNum;
            } else {
                currNum = q2.poll();
                q1.offer(currNum);
                sum1 += currNum;
                sum2 -= currNum;
            }
        }
        
        return count;
    }
}