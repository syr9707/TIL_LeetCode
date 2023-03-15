import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tt = 0; tt < t; tt++) {
			int n = Integer.parseInt(br.readLine());
			
			node[] a = new node[n + 2];
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				a[i] = new node(x, y);
			}
			LinkedList<Integer>[] g = new LinkedList[n+2];
			for(int i=0;i<n+2;i++) {
				g[i] = new LinkedList<>();
			}
			for(int i=0;i<n+1;i++) {
				for(int j=i+1;j<n+2;j++) {
					if(Math.abs(a[i].x-a[j].x)+Math.abs(a[i].y-a[j].y)<=1000) {
						g[i].add(j);
						g[j].add(i);
					}
				}
			}
			boolean c = false;
			boolean[] v = new boolean[n+2];
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			v[0] = true;
			while(!q.isEmpty()) {
				int now = q.poll();
				if(now==n+1) {
					c = true;
					break;
				}
				for(int i=0;i<g[now].size();i++) {
					if(!v[g[now].get(i)]) {
						v[g[now].get(i)] = true;
						q.add(g[now].get(i));
					}
				}
			}
			if(c) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}
			
		}
		System.out.println(sb);
	}

}

class node {
	int x, y ;

	public node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}