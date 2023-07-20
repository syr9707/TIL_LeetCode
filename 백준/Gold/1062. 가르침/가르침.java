import java.io.*;
import java.util.*;

public class Main {
    
	static int N, K;
	static int max = 0;
	static boolean visit[] = new boolean[26];
	static String[] sArr;

	public static void main(String[] args) throws IOException {
        
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sArr = new String[N];
		
		if(K<5) {
			System.out.println("0");
			return;
		} else if(K==26) {
			System.out.println(N);
			return;
		} else {
			for(int i=0; i<N; i++) {
				String str = bf.readLine();
				sArr[i] = str.substring(4, str.length()-4);
			}
			
			K -= 5;
			
			visit['a' - 97] = true;
			visit['n' - 97] = true;
			visit['t' - 97] = true;
			visit['i' - 97] = true;
			visit['c' - 97] = true;
			
			dfs(0, 0);
			System.out.println(max);
		}
		
		bf.close();
	}
    
    public static void dfs(int start, int count) {
		
		if(count == K) {
			int num = 0;
			for(int i=0; i<sArr.length; i++) {
				boolean flag = true;
				for(int j=0; j<sArr[i].length(); j++) {
					
					if(!visit[sArr[i].charAt(j) - 97]) {
						flag = false;
						break;
					}
				}
				if(flag)	num ++;
			}
			max = Math.max(max, num);
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, count + 1);
				visit[i] = false;
			}
		}
	}

}