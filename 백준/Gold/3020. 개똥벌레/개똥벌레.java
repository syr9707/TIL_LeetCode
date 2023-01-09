import java.util.*;
import java.io.*;

public class Main {
	
	static int N, H;
	static int[] bottom;
	static int[] top;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		bottom = new int[H + 1];
		top = new int[H + 1];
		
		for(int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());
			
			if(i % 2 == 0) bottom[height]++;
			else top[height]++;
		}
		
		int[] bottom_sum = new int[H + 1];
		int[] top_sum = new int[H + 1];
		for(int i = 1; i <= H; i++) {
			bottom_sum[i] = bottom_sum[i - 1] + bottom[i];
			top_sum[i] = top_sum[i - 1] + top[i];
		}
		
		int count = 0;
		int min = N;
		for(int i = 1; i <= H; i++) {
			int crush = (bottom_sum[H] - bottom_sum[i - 1]) + (top_sum[H] - top_sum[H - i]);
			
			if(crush < min) {
				min = crush;
				count = 1;
			} else if(crush == min) count++;
		}
		
		System.out.println(min + " " + count);

	}

}
