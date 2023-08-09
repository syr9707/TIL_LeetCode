import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int row = park.length;
        int col = park[0].length();
        char[][] map = new char[row][col];
        
        int nowX = 0;
        int nowY = 0;
        for(int i = 0; i < row; i++) {
            String str = park[i];
            for(int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    nowX = j;
                    nowY = i;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            int x = nowX;
            int y = nowY;
            
            String way = route[0];
            int cal = Integer.parseInt(route[1]);
            
            for(int j = 0; j < cal; j++) {
                if(way.equals("N")) {
                    y--;
                } else if(way.equals("S")) {
                    y++;
                } else if(way.equals("W")) {
                    x--;
                } else if(way.equals("E")) {
                    x++;
                }
                
                if(x >= 0 && y >= 0 && x < col && y < row) {
                    if(map[y][x] == 'X') break;
                    if(j == cal - 1) {
                        nowX = x;
                        nowY = y;
                    }
                }
            }
        }
        
        answer[0] = nowY;
        answer[1] = nowX;
        
        return answer;
    }
}