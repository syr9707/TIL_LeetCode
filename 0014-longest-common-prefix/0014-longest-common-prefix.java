import java.util.*;
import java.io.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        boolean flag = false;
        
        if(strs.length == 1) return strs[0];
        
        for(int i = strs[0].length(); i > 0; i--) {
            String common = strs[0].substring(0, i);
            
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].indexOf(common) != 0) break;
                
                if(j == strs.length - 1) flag = true;
            }
            
            if(flag == true) {
                answer = common;
                break;
            }
        }
        
        return answer;
    }
}