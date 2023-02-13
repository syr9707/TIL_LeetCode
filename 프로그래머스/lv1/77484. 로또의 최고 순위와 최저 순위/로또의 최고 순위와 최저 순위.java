import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int len = lottos.length;
        int count = 0;
        int win = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        for(int i = 0; i < len; i++) {
            if(lottos[i] != 0) break;
            count++;
        }
        
        int idx = len - 1;
        for(int i = len - 1; i >= 0; i--) {
            if(lottos[idx] == 0) {
                idx = idx + 1;
                break;
            }
            
            if(lottos[idx] == win_nums[i]) {
                win++;
                idx--;
            } else if(lottos[idx] > win_nums[i]) {
                idx--;
                i++;
            } else if(lottos[idx] < win_nums[i]) {
                
            }
        }
        
        int maxWin = win + count;
        int minWin = win;
        answer[0] = 7 - maxWin;
        answer[1] = 7 - minWin;
        if(answer[0] == 7) answer[0] = 6;
        if(answer[1] == 7) answer[1] = 6;
        
        return answer;
    }
}