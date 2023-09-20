import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[] parent;
    static boolean[] visited;
    static List<List<Integer>> adj;
    static int count =0;
    static int totalEdge =0;
    static int numOfGraph= 0 ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        HashSet<Integer> set = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        int operate =0;

        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            numOfGraph++;
            dfs(i);
            count++;
            operate += totalEdge/2 - (count-1);
            totalEdge = 0;
            count=0;
        }
        
        operate += numOfGraph-1;
        System.out.println(operate);
    }

    static void dfs(int x){
        visited[x]= true;
        
        for(int v : adj.get(x)){
            totalEdge ++;
            if(visited[v]) continue;
            dfs(v);
            count++;
        }
    }
}