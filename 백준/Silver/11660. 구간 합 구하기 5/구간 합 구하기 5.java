import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(j == 0) arr[i][j] = Integer.parseInt(st.nextToken());
				else arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int j = startY - 1; j < endY; j++) {
				if(startX == 1) sum += arr[j][endX - 1];
				else sum += arr[j][endX - 1] - arr[j][startX - 2];
			}
			
			sb.append(sum + "\n");
		}
		System.out.println(sb);

	}

}