import java.util.*;
import java.io.*;

public class Main {
	
	static int K, N;
	static long[] arr;
	static long max;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new long[K];
		
		for(int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		max = arr[K - 1];
		
		// 이분 탐색
		long left = 1;
		long right = max;
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			for(int i = 0; i < K; i++) { 
				sum += (arr[i] / mid);
			}
			
			if(sum >= N) { 
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);

	}

}
