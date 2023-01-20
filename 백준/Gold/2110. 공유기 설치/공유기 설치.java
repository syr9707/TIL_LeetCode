import java.util.*;
import java.io.*;

public class Main {
	
	static int N, C;
	static int[] home;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		home = new int[N];
		
		for(int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		
		int left = 1; 
		int right = home[N - 1] - home[0]; 
		int d = 0;
		int ans = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int start = home[0];
			int count = 1;
			
			for(int i = 0; i < N; i++) {
				d = home[i] - start;
				if(d >= mid) { 
					count++;
					start = home[i];
				}
			}
			
			if(count >= C) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);

	}

}
