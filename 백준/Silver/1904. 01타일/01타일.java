import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static long[] arr = new long[1000001];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			arr[i] = -1;
		}
		
		System.out.println(Fibonacci(N));

	}
	
	public static long Fibonacci(int n) {
		
		if(arr[n] == -1) {
			arr[n] = (Fibonacci(n - 1) + Fibonacci(n - 2)) % 15746;
		}
		
		return arr[n];
	}

}
