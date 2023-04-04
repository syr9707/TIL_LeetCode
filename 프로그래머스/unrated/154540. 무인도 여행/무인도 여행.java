import java.util.*;

class Solution {
    
    static char[][] map;
    static int row, col;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] check;
    static int sum = 0;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        row = maps.length;
        col = maps[0].length();
        
        map = new char[row][col];
        check = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            String s = maps[i];
            for(int j = 0; j < col; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] != 'X' && check[i][j] == false) {
                    result.add(dfs(i, j));
                    sum = 0;
                }
            }
        }
        
        if(result.size() == 0) return new int[] {-1};
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static int dfs(int startX, int startY) {
        check[startX][startY] = true;
        sum += map[startX][startY] - '0';
        
        for(int i = 0; i < 4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];
            
            if(x < 0 || x >= row || y < 0 || y >= col) continue;
            
            if(map[x][y] != 'X' && check[x][y] == false) {
                dfs(x, y);
            }
        }
        
        return sum;
    }
}