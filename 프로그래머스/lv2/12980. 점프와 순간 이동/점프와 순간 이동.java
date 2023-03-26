import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(true) {
            if(n % 2 == 0) n = n / 2;
            else if(n % 2 == 1) {
                n = (n - 1) / 2;
                ans++;
            }
            
            if(n == 0) break;
        }

        return ans;
    }
}