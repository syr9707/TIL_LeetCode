import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        int answerCount = 0;
        
        StringTokenizer st;
        
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String state = st.nextToken();
            if(!state.equals("Leave")) {
                String userId = st.nextToken();
                String nickName = st.nextToken();
                
                if(state.equals("Enter")) {
                    answerCount++;
                    map.put(userId, nickName);
                } else if(state.equals("Change")) {
                    map.replace(userId, nickName);
                }
                
            } else {
                String userId = st.nextToken();
                answerCount++;
            }
        }
        
        answer = new String[answerCount];
        int idx = 0;
        for(int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String state = st.nextToken();
            
            if(state.equals("Change")) {
                st.nextToken();
                st.nextToken();
                continue;
            }
            
            if(state.equals("Enter")) {
                String userId = st.nextToken();
                String nickName = st.nextToken();
                answer[idx] = map.get(userId) + "님이 들어왔습니다.";
                idx++;
            } else if(state.equals("Leave")) {
                String userId = st.nextToken();
                answer[idx] = map.get(userId) + "님이 나갔습니다.";
                idx++;
            }
            
        }
        
        return answer;
    }
    
}