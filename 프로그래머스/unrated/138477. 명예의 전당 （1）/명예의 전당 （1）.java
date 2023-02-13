import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int len = score.length;
        int[] answer = new int[len];
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            list.add(score[i]);
            Collections.sort(list, Collections.reverseOrder());
            if(i < k) answer[i] = list.get(i);
            else answer[i] = list.get(k - 1);
        }
        
        return answer;
    }
}