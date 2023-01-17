import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arrN;

	public static void main(String[] args) throws IOException {
		// 이분탐색 : 수 찾기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arrN = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int result = binarySearch(Integer.parseInt(st.nextToken()));
			
			if(result == -1) sb.append(0).append("\n");
			else sb.append(1).append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static int binarySearch(int target) {
		int left = 0;
		int right = arrN.length - 1;
		int mid;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(arrN[mid] < target) left = mid + 1;
			else if(arrN[mid] > target) right = mid - 1;
			else return mid;
		}
		
		return -1;
	}

}
