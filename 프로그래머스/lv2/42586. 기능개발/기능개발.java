import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < speeds.length; i++) {
            double num = (100 - progresses[i]) / (double)speeds[i];
            if(num > (int)num) q.offer((int)num + 1);
            else q.offer((int)num);
        }
        
        int count = 1;
        int now = q.poll();
        while(!q.isEmpty()) {
            int next = q.poll();
            
            if(now >= next) count++;
            else {
                list.add(count);
                now = next;
                count = 1;
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}