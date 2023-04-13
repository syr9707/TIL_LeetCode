import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(twoPointer(arr, M));

	}
	
	public static int twoPointer(int[] arr, int M) {
		int count = 0;
		int start = 0;
		int end = 0;
		int len = arr.length;
		int sum = 0;
		
		while(true) {
			if(sum >= M) sum -= arr[start++];
			else if(end >= len) break;
			else sum += arr[end++];
			
			if(sum == M) count++;
		}
		
		return count;
	}

}
