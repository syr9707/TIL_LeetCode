import java.util.*;
import java.io.*;

public class Main {
	
	static int H, W;
	static int[] map;
	static int ret, left, right;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W - 1; i++) {
			left = right = 0;
			
			for (int j = 0; j < i; j++) {
				left = Math.max(map[j], left);
			}
			
			for (int j = i + 1; j < W; j++) {
				right = Math.max(map[j], right);
			}
            
			if (map[i] < left && map[i] < right) {
				ret += Math.min(left, right) - map[i];
			}
		}
		System.out.println(ret);
	}
}
