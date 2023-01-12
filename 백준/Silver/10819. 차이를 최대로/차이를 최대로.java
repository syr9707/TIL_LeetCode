import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] newArr;
	static boolean[] visited;
	static int max = 0;

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		newArr = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backtracking(0);
		
		System.out.println(max);

	}
	
	public static void backtracking(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0; i < N - 1; i++) {
				sum += Math.abs(newArr[i + 1] - newArr[i]);
			}
			max = Math.max(max, sum);
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				newArr[depth] = arr[i];
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}

}
