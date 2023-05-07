import java.io.*;
import java.util.*;

public class Main {
	static int map[][], N;

	static class Pair {
		int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
        
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
        
		PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1.start == e2.start)
				return e2.end - e1.end;
			return e1.start - e2.start;
		});
        
		int maxday = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int u = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			pq.add(new Pair(u, v));
			maxday = Math.max(maxday, v);
		}
        
		map = new int[N][maxday + 2];
        
		// 달력 만들기
		while (!pq.isEmpty()) {
			Pair current = pq.poll();
			for (int i = 0; i < N; i++) {
				if (map[i][current.start] == 1) continue;
				for (int j = current.start; j <= current.end; j++) {
					map[i][j] = 1;
				}
				break;
			}
		}
        
		int widestart = 365;
		int wideend = 0;
		int height = 0;
		int areasum = 0;
		for (int j = 1; j < map[0].length; j++) {
			boolean stop = true;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 1) {
					wideend = Math.max(wideend, j);
					widestart = Math.min(widestart, j);
					height = Math.max(height, i + 1);
					stop = false;
				}
			}
            
			if (stop) {
				areasum += ((wideend - widestart + 1) * height);
				widestart = 365;
				wideend = 0;
				height = 0;
			}
		}
        
		System.out.println(areasum);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}