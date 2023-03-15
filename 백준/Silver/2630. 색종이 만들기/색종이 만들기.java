import java.util.*;
import java.io.*;

public class Main {
	
	static int white = 0; 
	static int blue = 0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);

	}
	
	public static void partition(int row, int col, int size) {
		
		if(colorCheck(row, col, size)) {
			if(arr[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return ; 
		}
		
		int newSize = size / 2; 
		
		partition(row, col, newSize); 
		partition(row, col + newSize, newSize); 
		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize); 
		
	}
	
	public static boolean colorCheck(int row, int col, int size) {
		
		int color = arr[row][col]; 
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
        
		return true;
	}

}