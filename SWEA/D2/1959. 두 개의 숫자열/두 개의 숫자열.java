import java.util.*;
import java.io.*;

class Solution {
	
	static int T;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arrN = new int[N];
			int[] arrM = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arrN[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < M; k++) {
				arrM[k] = Integer.parseInt(st.nextToken());
			}
			
			int t = Integer.MIN_VALUE;
			if(N <= M) t = mul(arrN, arrM);
			else if(N > M) t = mul(arrM, arrN);
			
			sb.append("#" + (i + 1) + " " + t + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int mul(int[] arr1, int[] arr2) {
		int max = Integer.MIN_VALUE;
		int mul = 0;
		int n = arr2.length - arr1.length;
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j < arr1.length; j++) {
				mul += arr1[j] * arr2[i + j];
			}
			max = Math.max(max, mul);
			mul = 0;
		}
		
		return max;
	}

}