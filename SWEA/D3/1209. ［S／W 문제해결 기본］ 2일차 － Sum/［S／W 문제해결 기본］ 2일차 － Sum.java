import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= 10; i++) {
			int t = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;
			
			int[][] arr = new int[100][100];
			for(int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sumRow = 0;
			int sumCol = 0;
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					sumRow += arr[j][k];
					sumCol += arr[k][j];
				}
				max = Math.max(Math.max(max, sumRow), sumCol);
				sumRow = 0;
				sumCol = 0;
			}
			
			int sumDae = 0;
			int sumMDae = 0;
			for(int j = 0; j < 100; j++) {
				sumDae += arr[j][j];
				sumMDae += arr[j][99 - j];
			}
			max = Math.max(Math.max(max, sumDae), sumMDae);
			
			sb.append("#" + t + " " + max + "\n");
		}
		
		System.out.println(sb);

	}

}
