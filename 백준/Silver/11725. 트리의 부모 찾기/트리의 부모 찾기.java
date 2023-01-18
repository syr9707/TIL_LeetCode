import java.util.*;
import java.io.*;

public class Main {
	
	static int N; // 노드의 개수
	static int[] parent; // 부모노드 저장
	static boolean[] isVisit; // 방문여부 확인
	static ArrayList<Integer> list[]; // 노드 저장

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isVisit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		
		for(int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
		
	}
	
	public static void dfs(int index) {
		isVisit[index] = true;
		for(int i : list[index]) {
			if(!isVisit[i]) {
				parent[i] = index; 
				dfs(i);
			}
		}
	}

}
