import java.io.*;
import java.util.*;
 
public class Main {
    
    static int n, k;
    static int [] arr;
    static int max;
    static int count;
    static boolean [] check;
    static int first=1, second=1;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        check = new boolean[n+1];
        arr= new int[n+1];
        
        String[] s1 = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(s1[i-1]);
            arr[i]=num;
            
            if(num%2!=1){
                check[i]=true;
            }
        }
        
        solve();
        System.out.println(max);
        
    }
 
    public static void solve(){
        while (second<=n){
            if(count<k){ 
                if(!check[second]){
                    count++;
                }
                second++;
                max = Math.max(max,second-first-count);
            } else if(check[second]){ 
                second++;
                max = Math.max(max,second-first-count);
            } else if(count==k && !check[second]){ 
                if(!check[first]){ 
                    count--;
                }
                first++;
            }
        }
    }
}