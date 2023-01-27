import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> carSet = new HashSet<>();
        
        StringTokenizer st;
        StringTokenizer st2;
        for(int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            String minuteStr = st.nextToken();
            String carNum = st.nextToken();
            String state = st.nextToken();
            
            st2 = new StringTokenizer(minuteStr, ":");
            int hour = Integer.parseInt(st2.nextToken());
            int minute = Integer.parseInt(st2.nextToken());
            int hours = hour * 60 + minute;
            
            if(state.equals("IN")) {
                carSet.add(carNum);
                if(map.get(carNum) == null) map.put(carNum, hours);
                else map.replace(carNum, map.get(carNum) + hours);
            } else if(state.equals("OUT")) {
                carSet.remove(carNum);
                map.replace(carNum, map.get(carNum) - hours);
            }
        }
        
        Iterator<String> iter = carSet.iterator();
        while(iter.hasNext()) {
            String idx = iter.next();
            map.replace(idx, Math.abs(map.get(idx) - (23 * 60 + 59)));
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        answer = new int[keySet.size()];
        for(int i = 0; i < keySet.size(); i++) {
            answer[i] = Math.abs(map.get(keySet.get(i)));
        }
        
        for(int i = 0; i < answer.length; i++) {
            if(answer[i] > fees[0]) {
                answer[i] = fees[1] + ((int)Math.ceil((double)(answer[i] - fees[0]) / fees[2])) * fees[3];
            } else {
                answer[i] = fees[1];
            }
        }
        
        return answer;
    }
}