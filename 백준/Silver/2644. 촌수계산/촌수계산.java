import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static List<Integer>[] relation;
	static int res = -1;
	static boolean[] checked;

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		relation = new ArrayList[n + 1];
		checked = new boolean[n + 1];
		
		for(int i = 1; i <= n; i++) {
			relation[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			relation[parent].add(child);
			relation[child].add(parent);
		}
		
		dfs(x, y, 0);
		System.out.println(res);

	}
	
	public static void dfs(int start, int end, int count) {
		if(start == end) {
			res = count;
			return ;
		}
		
		checked[start] = true;
		for(int i = 0; i < relation[start].size(); i++) {
			int next = relation[start].get(i);
			if(!checked[next]) {
				dfs(next, end, count + 1);
			}
		}
	}

}
