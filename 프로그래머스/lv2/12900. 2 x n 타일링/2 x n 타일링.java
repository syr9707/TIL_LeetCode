import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num % 1000000007;
        }
        answer = arr[n];
        
        return answer;
    }
}