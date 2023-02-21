import java.util.*;

class Solution {
    public int[] solution(int n) {
        int len = n * (n + 1) / 2;
        int[] answer = new int[len];
        int[][] map = new int[n][n];
        
        int x = 0;
        int y = 0;
        map[0][0] = 1;
        int value = 1;
        
        while(value < len) {
            // 왼쪽 : 위 -> 아래
            while(x + 1 < n && map[x + 1][y] == 0) {
                map[++x][y] = ++value;
            }
            
            // 아래 : 왼 -> 오
            while(y + 1 < n && map[x][y + 1] == 0) {
                map[x][++y] = ++value;
            }
            
            // 오른쪽 : 아래 -> 대각선 위
            while(y - 1 > 0 && x - 1 > 0 && map[x - 1][y - 1] == 0) {
                map[--x][--y] = ++value;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}