import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        int num = n;
        while(num > 0) {
            sb.append(num % k);
            num /= k;
        }
        String s = String.valueOf(sb.reverse());
        
        String[] arr = s.split("0");
        for(String str : arr) {
            if(str.equals("")) continue;
            
            if(isPrime(Long.parseLong(str))) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if(n <= 1) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
    
}