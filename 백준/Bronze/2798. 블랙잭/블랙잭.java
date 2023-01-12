import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			int sum1 = arr[i];
			if(sum1 > M) break;
			for(int j = i + 1; j < N; j++) {
				int sum2 = sum1 + arr[j];
				if(sum2 > M) break;
				for(int k = j + 1; k < N; k++) {
					int sum3 = sum2 + arr[k];
					if(sum3 > M) break;
					max = Math.max(max, sum3);
				}
			}
		}
		
		System.out.println(max);

	}

}
