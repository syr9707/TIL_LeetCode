import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        ArrayList<Character> list = new ArrayList<>();
        new_id = new_id.toLowerCase();
        for(int j = 0; j < new_id.length(); j++) {
            char c = new_id.charAt(j);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                list.add(c);
            }
        }
        
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(i != 0 && list.get(i) == '.' && list2.get(list2.size() - 1) == '.') continue;
            list2.add(list.get(i));
        }
        
        if(list2.get(0) == '.') list2.remove(0);
        if(list2.size() != 0 && list2.get(list2.size() - 1) == '.') list2.remove(list2.size() - 1);
        
        if(list2.size() == 0) list2.add('a');
        
        if(list2.size() >= 16) list2.subList(15, list2.size()).clear();
        
        if(list2.get(list2.size() - 1) == '.') list2.remove(list2.size() - 1);
        
        if(list2.size() <= 2) {
            char c = list2.get(list2.size() - 1);
            for(int i = 0; i <= 3 - list2.size(); i++) {
                list2.add(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : list2) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}