import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        for(String str : phone_book) {
            for(int i = 0; i < str.length(); i++) {
                if(map.containsKey(str.substring(0, i))) return false;
            }
        }
        
        return answer;
    }
}