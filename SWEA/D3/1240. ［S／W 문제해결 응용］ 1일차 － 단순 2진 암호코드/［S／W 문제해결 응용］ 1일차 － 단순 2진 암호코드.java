import java.util.*;
import java.io.*;

class Solution {
	
	static int[] pw;
	static int[] code = {13, 25, 19, 61, 35, 49, 47, 59, 55, 11};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		br.readLine();
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			pw = new int[8];
			String line;

			for (int i = 0; i < N; i++) {
				line = br.readLine();
				for (int j = M - 1; j >= M - 56 - 1; j--) {	
					if (line.charAt(j) == '1') {					
						int index = 0;
						for (int k = j - 55; k <= j; k += 7) {
							pw[index++] = convertCode(line.substring(k, k + 7));
						}
						break;
					}
				}
			}			
			bw.write(String.format("#%d %d\n",test_case, validateCode()));	
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int validateCode() {
		int validate = 0;
		int sum = 0;
		for(int i = 0; i<8; i++) {
			if(i % 2 == 0) {
				validate += 3*pw[i];
			} else {
				validate += pw[i];
			}
			sum += pw[i];
		}
		
		if(validate % 10 == 0) {
			return sum;
		} else {
			return 0;
		}
	}

	private static int convertCode(String binary) {
		int sum = 0;
		int n = 1;
		for(int i = 0; i<7; i++) {
			if(binary.charAt(6-i) == '1') {	
				sum += n;
			}
			n *= 2;
		}
		for(int i = 0; i<10; i++) {	
			if(sum == code[i]) {
				return i;
			}
		}		
		return 0;
	}
}
