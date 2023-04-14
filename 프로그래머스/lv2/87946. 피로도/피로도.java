import java.util.*;

class Solution {
    
    static int count = 0;
    static boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return count;
    }
    
    public static void dfs(int depth, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(check[i] == false && dungeons[i][0] <= k) {
                check[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                check[i] = false;
            }
        }
        
        count = Math.max(count, depth);
    }
    
}