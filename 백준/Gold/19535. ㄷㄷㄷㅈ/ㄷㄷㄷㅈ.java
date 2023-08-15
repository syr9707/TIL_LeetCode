import java.io.*;
import java.util.*;
 
public class Main {
 
    static int N;
    static long D, G;
    static boolean[] checked;
    static ArrayList<Integer>[] tree;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        checked = new boolean[N+1];
        
        for (int i = 1; i <= N; i++) 
            tree[i] = new ArrayList<>();
            
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree[a].add(b);
            tree[b].add(a);
        }
 
        // ㅈ Tree 찾기
        for (int i = 1; i <= N; i++) {
            if(tree[i].size() >= 3) {
                // nC3 = n!/3!(n-3)! = n(n-1)(n-2) / 3 * 2
                long n = tree[i].size();
                G += (n * (n-1) * (n-2)) / 6;
            }
        }
 
        // ㄷ Tree 찾기
        for (int p = 1; p <= N; p++) {
            long pChild = tree[p].size() - 1;
            
            for (int c = 0; c < tree[p].size(); c++) {
                if(checked[tree[p].get(c)]) continue;
                D += pChild * (tree[tree[p].get(c)].size() - 1);
            }
            checked[p] = true;
        }
 
        if(G * 3 < D) System.out.println("D");
        else if(G * 3 > D) System.out.println("G");
        else System.out.println("DUDUDUNGA");
    }
    
}