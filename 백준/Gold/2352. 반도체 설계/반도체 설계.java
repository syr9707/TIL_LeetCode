import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		int len =0;
		int idx =0;
		for(int i=0; i<n; i++) {
			if(arr[i]>dp[len]) {
				dp[++len] = arr[i];
			}else {
				idx = binarySearch(dp, 0, len, arr[i]);
				dp[idx] = arr[i];
			}
		}
		System.out.println(len);
	}
	static int binarySearch(int[] dp, int left, int right, int key) {
		int mid =0;
		while(left<right) {
			mid = (left+right)/2;
			if(dp[mid] < key) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return right;
	}
}