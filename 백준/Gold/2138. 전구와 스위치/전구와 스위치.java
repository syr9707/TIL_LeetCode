import java.io.*;

public class Main {
    
    public static int[] dx = {-1, 0, 1};
    public static int n;
    public static char[] data1;
    public static char[] data2;
    public static char[] data3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input1 = br.readLine();
        String input2 = br.readLine();
        data1 = new char[n];
        data2 = new char[n];
        data3 = new char[n];

        for(int i=0;i<n;i++){
            data1[i] = input1.charAt(i);
            data2[i] = data1[i];
            data3[i] = input2.charAt(i);
        }

        int ans = Integer.MAX_VALUE;

        int cnt1 = 0;
        int cnt2 = 0;

        data1 = change(data1, 0);
        cnt1++;

        for(int i=1;i<n;i++){
            if(data1[i-1] != data3[i-1]){
                data1 = change(data1, i);
                cnt1++;
            }
        }

        if(data1[n-1] == data3[n-1]){
            ans = Math.min(ans, cnt1);
        }

        for(int i=1;i<n;i++){
            if(data2[i-1] != data3[i-1]){
                data2 = change(data2, i);
                cnt2++;
            }
        }

        if(data2[n-1] == data3[n-1]){
            ans = Math.min(ans, cnt2);
        }


        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(ans);
        }

    }

    public static char[] change(char[] data, int i){
        for (int d = 0; d < 3; d++) {
            int nx = i + dx[d];
            if (nx < 0 || nx > n - 1) {
                continue;
            }

            if (data[nx] == '0') {
                data[nx] = '1';
            } else {
                data[nx] = '0';
            }
        }
        
        return data;
    }
}