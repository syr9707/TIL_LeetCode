import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public int solution(int[][] board) {
        int row = board.length;
        int col = board.length;
        int count = row * col;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = 2;
                    for(int k = 0; k < 8; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];
                        
                        if(y < 0 || y >= row || x < 0 || x >= col || board[y][x] == 1) continue;
                        
                        board[y][x] = 2;
                    }
                }
            }
        }
        
        for(int[] rows : board) {
            for(int cols : rows) {
                if(cols == 2) count--;
            }
        }
        
        return count;
    }
}