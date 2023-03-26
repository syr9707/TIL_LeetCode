import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] sum = new int[triangle.length][triangle.length];
        sum[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            sum[i][0] = sum[i - 1][0] + triangle[i][0];
            
            for(int j = 1; j <= i - 1; j++) {
                sum[i][j] = Math.max(sum[i - 1][j], sum[i - 1][j - 1]) + triangle[i][j];
            }
            
            sum[i][i] = sum[i - 1][i - 1] + triangle[i][i];
        }
        
        for(int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, sum[triangle.length - 1][i]);
        }
        
        return answer;
    }
}