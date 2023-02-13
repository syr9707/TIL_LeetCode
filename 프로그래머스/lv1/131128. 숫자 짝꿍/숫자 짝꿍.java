import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int lenX = X.length();
        int lenY = Y.length();
        int[] arrX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arrY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        for(int i = 0; i < lenX; i++) {
            arrX[X.charAt(i) - '0']++;
        }
        
        for(int i = 0; i < lenY; i++) {
            arrY[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < Math.min(arrX[i], arrY[i]); j++) {
                sb.append(i);
            }
        }
        
        String answer = sb.toString();
        if(answer.equals("")) return "-1";
        else if(answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}