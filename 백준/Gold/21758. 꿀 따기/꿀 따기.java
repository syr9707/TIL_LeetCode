import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine()); //  꿀통의 개수N
		int[] honey = new int[N+1];
		int[] sum = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum[i] = honey[i]+ sum[i-1];
		}

		int ans = 0;
		
		for(int i=2; i<=N-1; i++) {
			int tmp = sum[N] - honey[1] - honey[i] + sum[N] - sum[i];		
			ans = Math.max(ans, tmp);
		}
		
		//벌 벌통 벌
		for(int i=2; i<=N-1; i++) {
			//         오른쪽 벌         |  왼쪽벌  
			int tmp = sum[N-1]-sum[i-1]+sum[i]-sum[1];
			ans = Math.max(ans, tmp);
		}
		
		for(int i=2; i<=N-1; i++) {
			int tmp = sum[N-1] - honey[i] + sum[i-1];
			ans = Math.max(ans, tmp);
		}
        
		System.out.println(ans);
	}
}