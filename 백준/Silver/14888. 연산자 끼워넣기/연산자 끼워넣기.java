import java.util.*;
import java.io.*;

public class Main {
	
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int N;
	static int[] arr;
	static int[] operator = new int[4]; // 연산자 개수

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0], 1);
		
		System.out.println(MAX);
		System.out.println(MIN);

	}
	
	public static void dfs(int num, int idx) {
		if(idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return ;
		}
		
		for(int i = 0; i < 4; i++) {
			
			if(operator[i] > 0) {
				
				operator[i]--;
				
				switch(i) {
				case 0:
					dfs(num + arr[idx], idx + 1);
					break;
				case 1:
                    dfs(num - arr[idx], idx + 1);
                    break;
                case 2:
                    dfs(num * arr[idx], idx + 1);
                    break;
                case 3:
                    dfs(num / arr[idx], idx + 1);
                    break;
				}
				operator[i]++;
			}
		}
		
	}

}
