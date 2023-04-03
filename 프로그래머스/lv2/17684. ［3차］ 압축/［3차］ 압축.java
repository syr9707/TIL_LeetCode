import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        //int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 1;
        for(char c = 'A'; c <= 'Z'; c++) {
            map.put(c + "", idx++);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < msg.length(); i++) {
            int count = 1;
            while((i + count) <= msg.length() && map.containsKey(msg.substring(i, i + count))) {
                count++;
            }
            if(i + count > msg.length()) {
                list.add(map.get(msg.substring(i)));
                break;
            }
            list.add(map.get(msg.substring(i, i + count - 1)));
            map.put(msg.substring(i, i + count), idx++);
            if(count > 1) i = i + count - 2;
        }
        
        return list;
    }
}