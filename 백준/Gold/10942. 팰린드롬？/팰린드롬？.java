import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] check = new boolean[N + 1][N + 1];

		// 1자리일 경우
		for (int i = 0; i < N + 1; i++) {
			check[i][i] = true;
		}

		// 2자리일 경우
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i + 1]) {
				check[i][i + 1] = true;
			}
		}

		// 3자리 이상일 경우
		for (int i = 2; i < N; i++) {
			for (int j = 1; i + j <= N; j++) {
				if(check[j+1][j+i-1] && arr[j]==arr[j+i])
					check[j][j+i] = true;
			}
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			bw.append(check[start][end] ? 1 + "\n" : 0 + "\n");
		}
        
		bw.flush();
	}

}