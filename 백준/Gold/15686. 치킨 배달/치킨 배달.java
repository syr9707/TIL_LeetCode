import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static int[] select;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new int[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) home.add(new int[] {i, j});
				else if(num == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		dfs(0, 0);
		System.out.println(answer);
		
	}
	
	public static void dfs(int count, int start) {
		if(count == M) {
			int res = 0;
			for(int[] h : home) {
				int dis = Integer.MAX_VALUE;
				for(int c : select) {
					dis = Math.min(Math.abs(h[0] - chicken.get(c)[0]) + Math.abs(h[1] - chicken.get(c)[1]), dis);
				}
				res += dis;
			}
			answer = Math.min(answer, res);
			return ;
		}
		for (int i = start; i < chicken.size(); i++) {
            select[count] = i;
            dfs(count + 1, i + 1);
        }
	}

}
