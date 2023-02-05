import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        boolean flag = false;
        for(int i = 0; i < completion.length; i++) {
            if(!(participant[i].equals(completion[i]))) {
                answer = participant[i];
                flag = true;
                break;
            }
        }
        if(!flag) answer = participant[participant.length - 1];
        
        return answer;
    }
}