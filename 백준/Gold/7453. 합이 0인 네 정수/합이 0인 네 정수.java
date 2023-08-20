import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long answer = 0;
    static int[][] data;
    static int preSum[][];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        data = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
            data[i][3] = Integer.parseInt(st.nextToken());
        }

        preSum = new int[2][N * N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                preSum[0][count] = data[i][0] + data[j][1];
                preSum[1][count++] = data[i][2] + data[j][3];
            }
        }
        
        Arrays.sort(preSum[0]);
        Arrays.sort(preSum[1]);
        int first = 0;
        int second = preSum[0].length - 1;

        int end = N * N;
        while (first < end && 0 <= second) {
            int sum =  preSum[0][first] + preSum[1][second];
            int firstCnt =1;
            int secondCnt = 1;
            if (sum == 0) {
                while (first <= end - 2 && preSum[0][first] == preSum[0][first + 1]) {
                    firstCnt++;
                    first++;
                }
                while (0 < second && preSum[1][second] == preSum[1][second - 1]) {
                    secondCnt++;
                    second--;
                }
                answer += (long) firstCnt * secondCnt;
            }

            if (sum < 0) {
                first++;
            } else{
                second--;
            }
        }
        System.out.println(answer);
    }
}