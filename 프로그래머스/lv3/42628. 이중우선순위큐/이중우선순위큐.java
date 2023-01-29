import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        int val = 0;
        
        for(int i = 0; i < operations.length; i++) {
            String op = operations[i];
            char opType = op.charAt(0);
            
            if(opType == 'D') {
                if(op.charAt(2) == '-') {
                    if(!minPq.isEmpty()) {
                        val = minPq.poll();
                        maxPq.remove(val);
                    }
                } else {
                    if(!maxPq.isEmpty()) {
                        val = maxPq.poll();
                        minPq.remove(val);
                    }
                }
            } else {
                int value = Integer.parseInt(op.substring(2));
                maxPq.offer(value);
                minPq.offer(value);
            }
        }
        
        if(!maxPq.isEmpty()) {
            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
        }
        
        return answer;
    }
}