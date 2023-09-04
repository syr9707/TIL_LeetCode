import java.util.*;
import java.io.*;

public class Main {
	
	static long A, B;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		System.out.println(bfs());

	}
	
	public static int bfs() {
		Queue<Long> q = new LinkedList<>();
		q.add(A);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				long temp = q.poll();
				
				if(temp == B) return count + 1;
				
				if(temp * 2 <= B) q.add(temp * 2);
				if(temp * 10 + 1 <= B) q.add(temp * 10 + 1);
			}
			
			count++;
		}
		
		return -1;
	}

}