import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        // P를 중심으로 탐색
        
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            String[] place = places[i];
            
            boolean isOk = true;
            for(int j = 0; j < 5 && isOk; j++) {
                for(int k = 0; k < 5 && isOk; k++) {
                    if(place[j].charAt(k) == 'P') {
                        if(!bfs(j, k, place)) {
                            isOk = false;
                        }
                    }
                }
                answer[i] = isOk ? 1 : 0;
            }
        }
        
        return answer;
    }
    
    public static boolean bfs(int row, int col, String[] place) {
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                
                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || (nr == row && nc == col)) continue;
                
                int d = Math.abs(nr - row) + Math.abs(nc - col);
                
                if(place[nr].charAt(nc) == 'P' && d <= 2) return false;
                else if(place[nr].charAt(nc) == 'O' && d < 2) q.offer(new int[] {nr, nc});
            }
        }
        
        return true;
    }
}