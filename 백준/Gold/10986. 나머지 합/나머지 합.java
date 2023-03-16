import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken()) % M;
		arr[sum]++;
		for(int i = 1; i < N; i++) {
			sum = (sum + Integer.parseInt(st.nextToken())) % M;
			arr[sum]++;
		}
		
		long answer = arr[0];
		for(int i = 0; i < M; i++) {
			if(arr[i] == 0) continue;
			answer += (long)arr[i] * (arr[i] - 1) / 2;
		}
		System.out.println(answer);

	}

}