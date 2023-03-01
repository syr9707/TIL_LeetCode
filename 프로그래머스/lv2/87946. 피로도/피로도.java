import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!check[i] && dungeons[i][0] <= k) {
                check[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                check[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
    
}