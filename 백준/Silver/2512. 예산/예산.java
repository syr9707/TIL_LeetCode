import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		
		int start = 0;
        int end = arr[N - 1];
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int value : arr) {
                if (value >= mid)
                    sum += mid;
                else
                    sum += value;
            }
            if (sum > M)
                end = mid - 1;
            else {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);

	}

}
