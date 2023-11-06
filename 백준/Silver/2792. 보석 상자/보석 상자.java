import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[M];
        int left = 1, right = 0, mid = 0, sum, answer = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            right = Math.max(right, arr[i]);
        }

        // 이분 탐색 하면서 최솟값 찾기
        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0;
            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    sum++;
                }
            }

            if (sum > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}