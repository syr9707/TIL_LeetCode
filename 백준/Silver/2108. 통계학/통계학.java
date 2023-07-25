import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		double sum = 0.0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		System.out.println(Math.round(sum / N)); // 평균
		
		Arrays.sort(arr);
		System.out.println(arr[N / 2]); // 중앙값
		
		int count = 0;
		int max = -1;
		int mod = arr[0];
		boolean check = false;
		
		for(int i = 0; i < N - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				count++;
			}
			else {
				count = 0;
			}
			
			if(max < count) {
				max = count;
				mod = arr[i];
				check = true;
			}
			else if(max == count && check == true) {
				mod = arr[i];
				check = false;
			}
		}
		
		System.out.println(mod); // 최반값
		System.out.println(arr[N - 1] - arr[0]); // 범위

	}

}