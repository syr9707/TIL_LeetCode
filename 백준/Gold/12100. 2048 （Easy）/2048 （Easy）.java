import java.util.*;
import java.io.*;

public class Main {
	
	static int[] moveR = {-1, 1, 0, 0};
    static int[] moveC = {0, 0, -1, 1};
    static int result = 0;

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(info[j]);
            }
        }

        recursion(0, 5, board);

        System.out.println(result);

	}
	
	public static void recursion(int index, int limit, int[][] board) {

        if (index == limit) {
            int tempReulst = 0;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    tempReulst = Math.max(tempReulst, board[i][j]);
                }
            }

            result = Math.max(result, tempReulst);

            return;
        }

        for (int i = 0; i < 4; i++) {

            boolean[][] sumChk = new boolean[board.length][board.length];

            int[][] tempBoard = new int[board.length][board.length];
            for (int q = 0; q < board.length; q++) {
                for (int j = 0; j < board.length; j++) {
                    tempBoard[q][j] = board[q][j];
                }
            }

            if (i == 0 || i==2) {
                for (int j = 0; j < tempBoard.length; j++) {
                    for (int k = 0; k < tempBoard[j].length; k++) {
                        move(tempBoard, sumChk, i, j, k);
                    }
                }
            } else if (i == 1 || i == 3) {
                for (int j = tempBoard.length - 1; j >= 0; j--) {
                    for (int k = tempBoard[j].length; k >= 0; k--) {
                        move(tempBoard, sumChk, i, j, k);
                    }
                }
            }

            recursion(index +1, limit, tempBoard);
        }

    }
	
	public static void move(int[][] board, boolean[][] sumChk, int i, int j, int k) {
        int nowRow = j;
        int nowCol = k;
        int moveRow = nowRow + moveR[i];
        int moveCol = nowCol + moveC[i];

        if (moveRow >= board.length || moveRow < 0 || moveCol >= board.length || moveCol < 0) {
            return;
        }

        boolean end = false;

        while (!end) {
            if (board[moveRow][moveCol] == 0) {
                board[moveRow][moveCol] = board[nowRow][nowCol];
                board[nowRow][nowCol] = 0;
                nowRow = moveRow;
                nowCol = moveCol;
                moveRow = nowRow + moveR[i];
                moveCol = nowCol + moveC[i];
                if (moveRow >= board.length || moveRow < 0 || moveCol >= board.length || moveCol < 0) {
                    end = true;
                }
            } else if (board[moveRow][moveCol] == board[nowRow][nowCol]) {
                if (!sumChk[moveRow][moveCol]) {
                    board[moveRow][moveCol] = board[moveRow][moveCol] * 2;
                    board[nowRow][nowCol] = 0;
                    sumChk[moveRow][moveCol] = true;
                }
                end = true;
            }
            else {
                end = true;
            }
        }
    }
}
