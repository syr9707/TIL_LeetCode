import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        while(n > 0) {
            int work = pq.poll();
            if(work == 0) break;
            
            work--;
            pq.offer(work);
            n--;
        }
        
        for(int work : pq) {
            answer += Math.pow(work, 2);
        }
        
        if(n > 0) answer = 0;
        
        return answer;
    }
}