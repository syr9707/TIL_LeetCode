import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 수 입력
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 정렬
		Arrays.sort(arr);
		
		int answer = Integer.MAX_VALUE;
		
		int s = 0; // 작은 쪽 포인터
		int e = 0; // 큰 쪽 포인터
		// 끝날 때 까지 반복
		while(e < N && s <= e) {
			int rst = arr[e] - arr[s]; // 두 포인터가 가리키는 값의 차
			// 두 값의 차이가 M 이상이면
			// s++, 그 차이의 최소값 구하기
			if(rst >= M) {
				s++;
				answer = Math.min(answer, rst);
			} 
			// 두 값의 차이가 M보다 작으면 e++
			else {
				e++;
			}
		}
		
		System.out.println(answer);
	}

}