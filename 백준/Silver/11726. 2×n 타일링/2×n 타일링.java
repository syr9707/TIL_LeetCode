import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		
		arr[1] = 1;
		if(n != 1) arr[2] = 2;
		for(int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
		}
		
		System.out.println(arr[n]);

	}

}
