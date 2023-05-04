import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[] answer = new int[100001];
        // 0원 거슬러 주는 방법 : 1
        answer[0] = 1;
        
        // 모든 money에 대응해서 처리
        for(int i = 0; i < money.length; i++) {
            for(int j = money[i]; j <= n; j++) {
                answer[j] += answer[j - money[i]];
                answer[j] %= 1000000007;
            }
        }
        
        return answer[n];
    }
}