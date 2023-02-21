import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        
        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            } else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            } else {
                if(num == 0) num = 11;
                int leftDist = Math.abs((left - num) / 3) + Math.abs((left - num) % 3);
                int rightDist = Math.abs((right - num) / 3) + Math.abs((right - num) % 3);
                
                if(leftDist < rightDist) {
                    sb.append("L");
                    left = num;
                } else if(leftDist > rightDist) {
                    sb.append("R");
                    right = num;
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        left = num;
                    } else {
                        sb.append("R");
                        right = num;
                    }
                }
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}