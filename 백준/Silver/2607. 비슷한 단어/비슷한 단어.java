import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()) - 1;
		int[] alpha = new int[26];
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - 'A']++;
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			String out = br.readLine();
			int[] beta = alpha.clone();
            int same = 0;

            for(int j = 0; j < out.length(); j++){
                if(beta[out.charAt(j) - 'A'] > 0){
                    same++;
                    beta[out.charAt(j) - 'A']--;
                }
            }

            if(out.length() == str.length()-1 && same == out.length())
                cnt++;
            else if(out.length() == str.length()){
                if(same == str.length()-1 || same == str.length())
                    cnt++;
            }
            else if(out.length() == str.length()+1){
                if(same == str.length())
                    cnt++;
            }
        }
        System.out.print(cnt);
    }
}
