import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int board_len = board.length - 1;
        int moves_len = moves.length;
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < moves_len; i++) {
            int num = moves[i] - 1;
            if(board[board_len][num] == 0) continue;
            
            for(int j = 0; j <= board_len; j++) {
                if(board[j][num] == 0) continue;
                else {
                    if(stack.size() != 0) {
                        if(board[j][num] == stack.peek()) {
                            stack.pop();
                            answer = answer + 2;
                            board[j][num] = 0;
                            break;
                        }
                    }
                    stack.push(board[j][num]);
                    board[j][num] = 0;
                    break;
                }
            }
        }
        
        System.out.println(stack);
        
        return answer;
    }
}