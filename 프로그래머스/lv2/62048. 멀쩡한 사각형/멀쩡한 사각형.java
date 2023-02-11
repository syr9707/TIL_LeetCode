import java.util.*;
import java.math.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        
        answer =  ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
        
        return answer;
    }
}