import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weight = new int[n];

        for (int i=0; i<n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int sum = 0;
        for (int i=0; i<n; i++) {
            if (sum + 1 < weight[i]) {
                break;
            }

            sum += weight[i];
        }

        System.out.println(sum + 1);
    }
}