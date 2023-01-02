import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(map.get(n) == null) map.put(n, 1);
			else map.put(n, map.get(n) + 1);
		}
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(map.get(n) == null) sb.append(0 + " ");
			else sb.append(map.get(n) + " ");
		}
		System.out.println(sb);

	}

}