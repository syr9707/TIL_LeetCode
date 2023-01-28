import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] check = new boolean[11][11][11][11];
        
        int x = 5;
        int y = 5;
        int nextX = 5;
        int nextY = 5;
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if(c == 'U') {
                nextY = y - 1;
            } else if(c == 'D') {
                nextY = y + 1;
            } else if(c == 'R') {
                nextX = x + 1;
            } else if(c == 'L') {
                nextX = x - 1;
            }
            if(nextX < 0) nextX = 0;
            if(nextY < 0) nextY = 0;
            if(nextX > 10) nextX = 10;
            if(nextY > 10) nextY = 10;
            
            if(check[y][x][nextY][nextX] == false && check[nextY][nextX][y][x] == false) {
                if(x == nextX && y == nextY) continue;
                answer++;
            }
            check[y][x][nextY][nextX] = true;
            check[nextY][nextX][y][x] = true;
            
            x = nextX;
            y = nextY;
        }
        
        return answer;
    }
}