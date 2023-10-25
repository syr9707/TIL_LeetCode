import java.io.*;
import java.util.*;

class Main {

    static int[][][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        graph = new int[m + 2][n + 2][3];
        
        for (int i = 0; i < m; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                switch (chars[j]) {
                    case 'J':
                        graph[i + 1][j + 1][0] = 1;
                        break;
                    case 'O':
                        graph[i + 1][j + 1][1] = 1;
                        break;
                    case 'I':
                        graph[i + 1][j + 1][2] = 1;
                        break;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int l = 0; l < 3; l++) {
                    graph[i][j][l] += graph[i - 1][j][l];
                }
            }
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int l = 0; l < 3; l++) {
                    graph[i][j][l] += graph[i][j - 1][l];
                }
            }
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(
                    graph[r2][c2][i] - graph[r1 - 1][c2][i] - graph[r2][c1 - 1][i] + graph[r1 - 1][
                        c1 - 1][i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}