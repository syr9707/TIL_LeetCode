import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int j = 0; j < N; j++) {
				String s = br.readLine();
				for(int k = 0; k < N; k++) {
					arr[j][k] = s.charAt(k) - '0';
				}
			}
			
			int sum = 0;
			for(int j = 0; j < N / 2; j++) {
				for(int k = N / 2 - j; k <= N / 2 + j; k++) {
					sum += arr[j][k];
				}
			}
			
			for(int j = N / 2; j >= 0; j--) {
				for(int k = N / 2 - j; k <= N / 2 + j; k++) {
					sum += arr[N - j - 1][k];
				}
			}
			
			sb.append("#" + i + " " + sum + "\n");
		}
		
		System.out.println(sb);

	}

}
