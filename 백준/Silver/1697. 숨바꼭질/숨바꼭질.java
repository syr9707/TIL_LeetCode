import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println(0);
			return;
		}
		
		boolean[] check = new boolean[100001];
		check[N] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int size = q.size();
		int count = 0;
		
		while(true) {
			count++;
			size = q.size();
			
			for(int i = 0; i < size; i++) { 
				int x = q.poll();
				check[x] = true;
				
				if(x - 1 == K || x + 1 == K || x * 2 == K) {
					System.out.println(count);
					return;
				}
				if(x - 1 >= 0 && check[x - 1] == false) {
					check[x - 1] = true;
					q.add(x - 1);
				}
				if(x + 1 <= 100000 && check[x + 1] == false) {
					check[x + 1] = true;
					q.add(x + 1);
				}
				if(x * 2 <= 100000 && check[x * 2] == false) {
					check[x * 2] = true;
					q.add(x * 2);
				}
			}
		}
		
	}

}