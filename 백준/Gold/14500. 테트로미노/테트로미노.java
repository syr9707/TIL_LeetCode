import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visit;
	static int ans;
	
	static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, arr[i][j], visit);
                visit[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(ans);

	}
	
	static void dfs(int y, int x, int cnt, int sum, boolean[][] visit) {

        if (cnt >= 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                continue;
            }

            visit[ny][nx] = true;
            dfs(ny, nx, cnt + 1, sum + arr[ny][nx], visit);
            visit[ny][nx] = false;
        }
    }

    static void check(int y, int x) {
        if (y < N - 2 && x < M - 1)
            ans = Math.max(ans, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x + 1]);

        if (y < N - 2 && x > 0)
            ans = Math.max(ans, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x - 1]);

        if (y < N - 1 && x < M - 2)
            ans = Math.max(ans, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1]);

        if (y > 0 && x < M - 2)
            ans = Math.max(ans, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y - 1][x + 1]);
    }

}
