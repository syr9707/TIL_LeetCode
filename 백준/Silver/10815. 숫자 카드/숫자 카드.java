import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] num;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int result = binarySearch(Integer.parseInt(st.nextToken()));
			
			if(result != -1) sb.append(1 + " ");
			else sb.append(0 + " ");
		}
		
		System.out.println(sb);

	}
	
	public static int binarySearch(int target) {
		int left = 0;
		int right = num.length - 1;
		int mid;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(num[mid] < target) left = mid + 1;
			else if(num[mid] > target) right = mid - 1;
			else return mid;
		}
		
		return -1;
	}

}
