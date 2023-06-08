import java.util.*;
import java.io.*;

public class Main {
	
	static class node{
        int num;
        int weight;

        node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }

    static int n, dist, farthestNode;
    static ArrayList<node> adj[];
    static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		dist = 0;
        farthestNode = 0;
        adj = new ArrayList[n+1];
        isVisited = new boolean[n+1];

        for(int i = 0 ; i < n+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[p].add(new node(c, w));
            adj[c].add(new node(p, w));
        }

        isVisited[1] = true;
        DFS(1, 0);

        isVisited = new boolean[n+1];
        dist = 0;
        isVisited[farthestNode] = true;
        DFS(farthestNode, 0);

        System.out.println(dist);

	}
	
	public static void DFS(int nodeNum, int distSum) {

        if(dist < distSum){
            dist = distSum;
            farthestNode = nodeNum;
        }
        
        for(node next : adj[nodeNum]){
            if(isVisited[next.num]) continue;

            isVisited[next.num] = true;
            DFS(next.num, distSum + next.weight);
        }
    }

}
