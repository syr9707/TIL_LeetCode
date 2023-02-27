import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = discount.length;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        int discountLength = discount.length;
        for (int i = 0; i <= discountLength - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                String item = discount[i + j];
                int count = discountMap.getOrDefault(item, 0);
                count++;
                discountMap.put(item, count);
            }

            boolean isSignup = true;
            for (String wantItem : map.keySet()) {
                int wantCount = map.get(wantItem);
                int discountCount = discountMap.getOrDefault(wantItem, 0);
                if (wantCount > discountCount) {
                    isSignup = false;
                    break;
                }
            }

            if (isSignup) {
                answer++;
            }
        }
        
        return answer;
    }
}