import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static int R, C, Q;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		
        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++)
            	map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int cnt = ((r2 - r1) + 1) * ((c2 - c1) + 1);
            sb.append((map[r2][c2] - map[r1-1][c2] - map[r2][c1-1] + map[r1-1][c1-1]) / cnt).append("\n");
        }
		
		System.out.println(sb.toString());

	}

}
