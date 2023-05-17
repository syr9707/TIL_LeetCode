import java.util.*;
import java.io.*;

class Solution {
	
	static int max;
    static int len;
    static char[] strs;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
        for(int z = 1 ; z <= tc ; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            strs = str.toCharArray();
            len = str.length();
        
            max = 0;
            
            go(0, change);
            System.out.println("#"+z+" "+max);
        }

	}
	
	static void swap(int a, int b) {
        char tmp = strs[a];
        strs[a] = strs[b];
        strs[b] = tmp;
    }
	
	static void go(int change_pos, int cnt) {
		 
        if(cnt%2 == 0)
            max = Math.max(max, Integer.parseInt(new String(strs)));
        
        if(cnt == 0) {
            return;
        }
        
        if(change_pos == len-1) {
            if(cnt%2 == 1) {
                swap(len-2, len-1);
                max = Math.max(max, Integer.parseInt(new String(strs)));
                swap(len-2, len-1);
            }
            return;
        }
 
        go(change_pos+1, cnt);
        
        int max_num = strs[change_pos] - '0';
        for(int i = change_pos+1 ; i < len ; i++) {
            if(max_num <= strs[i] - '0') {
                swap(i, change_pos);
                go(change_pos+1 , cnt-1);
                swap(i, change_pos);
            }
        }
            
    }

}