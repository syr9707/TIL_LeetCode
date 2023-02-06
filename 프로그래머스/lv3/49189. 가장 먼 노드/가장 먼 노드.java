import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) { // 2 ~ n까지 도착하는 경로 구하기
            int now = q.poll();
            ArrayList<Integer> node = graph.get(now);
            for(int i = 0; i < node.size(); i++) {
                if(visited[node.get(i)] == false) {
                    q.add(node.get(i));
                    visited[node.get(i)] = true;
                    distance[node.get(i)] = distance[now] + 1;
                }
            }
        }
        
        Arrays.sort(distance);
        int max = distance[distance.length - 1];
        for(int i = 0; i < distance.length; i++) {
            if(max == distance[i]) answer++;
        }
        
        return answer;
    }
}