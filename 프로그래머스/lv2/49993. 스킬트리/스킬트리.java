import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String str : skill_trees) {
            String temp = str;
            
            for(int i = 0; i < str.length(); i++) {
                String s = str.substring(i, i + 1);
                if(!skill.contains(s)) temp = temp.replace(s, "");
            }
            
            if(skill.indexOf(temp) == 0) answer++;
        }
        
        return answer;
    }
}