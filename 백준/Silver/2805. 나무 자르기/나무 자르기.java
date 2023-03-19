import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		long start = 0;
		long end = max;
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for(int tree : arr) {
				if(tree > mid) sum += tree - mid;
			}
			
			if(sum >= M) start = mid + 1;
			else end = mid - 1;
		}
		System.out.println(end);

	}

}