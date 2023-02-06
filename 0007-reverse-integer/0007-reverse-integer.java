import java.util.*;

class Solution {
    public int reverse(int x) {
        int sign = 1;
        
        if(x < 0) sign = -1;
        
        x = Math.abs(x);
        
        int curr = 0;
        int prev = 0;
        
        while(x > 0) {
            int digit = x % 10;
            curr = (curr * 10) + digit;
            
            int newPrev = (curr - digit) / 10;
            
            if(prev != newPrev) return 0;
            
            x /=10;
            prev = curr;
        }
        
        return curr * sign;
    }
}