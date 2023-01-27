import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n][m];
        map[0][0] = 1;
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                if(!(i == 0 && j == 0)) {
                    int left = 0;
                    int up = 0;
                    
                    if(j > 0) left = map[i][j - 1];
                    if(i > 0) up = map[i - 1][j];
                    
                    map[i][j] = (left + up) % 1000000007;
                }
            }
        }
        
        answer = map[n - 1][m - 1];
        
        return answer;
    }
}