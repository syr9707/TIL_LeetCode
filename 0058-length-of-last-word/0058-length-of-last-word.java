import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] answer = s.split(" ");
        
        return answer[answer.length - 1].length();
    }
}