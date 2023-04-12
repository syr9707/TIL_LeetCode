import java.util.*;

class Solution {
    
    int[] Sales;
    int[][] cost = new int[300000][2];
    List<Integer>[] adj;
    
    public int solution(int[] sales, int[][] links) {
        Sales = sales;
        adj = new ArrayList[Sales.length];
        
        for(int i = 0; i < Sales.length; i++)
            adj[i] = new ArrayList<>();
        
        for(int[] link : links)
            adj[link[0] - 1].add(link[1] - 1);
        
        dfs(0);
        return Math.min(cost[0][0], cost[0][1]);
    }
    
    public void dfs(int idx) {
       	cost[idx][0] = 0;
        cost[idx][1] = Sales[idx];
        
        if(adj[idx].isEmpty())
            return;
        
        int extra = (int)1e9;
        for(int child : adj[idx]) {
            dfs(child);
            if(cost[child][0] < cost[child][1]) {
                cost[idx][0] += cost[child][0];
                cost[idx][1] += cost[child][0];
                extra = Math.min(extra, cost[child][1] - cost[child][0]);
            } else {
                cost[idx][0] += cost[child][1];
                cost[idx][1] += cost[child][1];
                extra = 0;
            }
        }
        
        cost[idx][0] += extra;
    }
}