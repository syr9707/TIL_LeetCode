import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr[N + i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N + M; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb.toString());

	}

}
