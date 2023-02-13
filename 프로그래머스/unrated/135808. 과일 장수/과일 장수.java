import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = score.length;
        
        Arrays.sort(score);
        for(int i = len - 1; i >= len % m; i -= m) {
            answer += (score[i - m + 1] * m);
        }
        
        return answer;
    }
}