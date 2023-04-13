import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < X; i++) {
			sum += arr[i];
		}
		list.add(sum);
		
		int max = sum;
		for(int i = X; i < N; i++) {
			sum = sum + arr[i] - arr[i - X];
			max = Math.max(max, sum);
			list.add(sum);
		}
		
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == max) count++;
		}
		
		if(max != 0) {
			System.out.println(max);
			System.out.println(count);
		} else System.out.println("SAD");

	}

}
