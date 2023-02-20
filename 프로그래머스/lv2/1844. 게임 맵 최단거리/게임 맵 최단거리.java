import java.util.*;

class Solution {
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    static int row, col;
    
    public int solution(int[][] maps) {
        // BFS : 최단 경로
        int answer = 0;
        row = maps.length;
        col = maps[0].length;
        
        int[][] visited = new int[row][col];
        
        bfs(maps, visited);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0) answer = -1;
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int cx = curr[0];
            int cy = curr[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                
                if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}