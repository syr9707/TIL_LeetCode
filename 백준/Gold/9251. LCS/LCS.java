import java.util.*;
import java.io.*;

public class Main {
	
	static String str1;
	static String str2;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine();
		str2 = br.readLine();
		
		int length1 = str1.length();
		int length2 = str2.length();
		
		dp = new int[length2 + 1][length1 + 1];
		
		for(int i = 1; i <= length2; i++) {
			char C = str2.charAt(i - 1);
			for(int j = 1; j <= length1; j++) {
				if(C == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[length2][length1]);

	}

}
