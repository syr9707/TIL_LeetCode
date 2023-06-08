import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] list;
	static int result = 0;
	static int start = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			
			if(node != -1) list[node].add(i);
			else start = i;
		}
		
		int delete = Integer.parseInt(br.readLine());
		
		CountLeaf(delete);
		
		System.out.println(result);

	}
	
	public static void CountLeaf(int delete) {
		Queue<Integer> q = new LinkedList<>();
		
		if(delete == start) return;
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			int count = 0;
			
			for(Integer i : list[node]) {
				if(i != delete) {
					q.add(i);
					count++;
				}
			}
			
			if(count == 0) result++;
		}
	}

}
