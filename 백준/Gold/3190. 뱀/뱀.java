import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static List<int[]> snake = new ArrayList<>();
	static int n, k, l;
	static HashMap<Integer, String> hash = new HashMap<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;

		}

		l = Integer.parseInt(br.readLine());

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			hash.put(x, c);
		}

		solve();

	}

	public static void solve() {
		int cx = 0, cy = 0;
		int time = 0;
		int d = 0;
		snake.add(new int[] { 0, 0 });

		while (true) {
			time++;

			int nx = cx + dx[d];
			int ny = cy + dy[d];

			if (isFinish(nx, ny)) break;

			if (map[nx][ny] == 1) {
				map[nx][ny] = 0;
				snake.add(new int[] { nx, ny });

			} else {
				snake.add(new int[] { nx, ny });
				snake.remove(0);
			}

			if (hash.containsKey(time)) {
				if (hash.get(time).equals("D")) {
					d += 1;
					if (d == 4)
						d = 0;
				} else {
					d -= 1;
					if (d == -1)
						d = 3;
				}
			}

			cx = nx;
			cy = ny;
		}

		System.out.println(time);
	}

	public static boolean isFinish(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
			return true;
		}

		for (int i = 0; i < snake.size(); i++) {
			int[] t = snake.get(i);
			if (nx == t[0] && ny == t[1])
				return true;
		}
		return false;
	}

}