import java.util.*;
import java.io.*;
	
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine())+arr[i-1];
        }
        
        int maxVal = Integer.MIN_VALUE;
        for (int a = 1; a <= N; a++) {
            for (int b = a; b <= N; b++) {
                int RightDistance = arr[b-1]-arr[a-1];
                int LeftDistance = arr[N]-RightDistance;
                int D = Math.min(RightDistance,LeftDistance);
                maxVal = Math.max(maxVal, D);
                if(RightDistance>=LeftDistance) break;
            }
        }
        
        System.out.println(maxVal);
    }
}