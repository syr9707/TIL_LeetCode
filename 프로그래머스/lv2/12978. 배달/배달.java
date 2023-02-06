import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];
        
        //모든 map값의 INF값을 넣는다.(플로이드 와샬 쓰기위해) map[정점][정점]은 0으로초기화
        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[1].length; j++) {
                if(i == j) continue;
                map[i][j] = 500001;
            }
        }
        
        // 정점과 정점을 연결해주는 맵을 그린다. 
        for(int[] n : road) {
            //새로운 다리가 기존에 있던 다리보다 크면 넘긴다. 작으면 갱신한다. 
            if(map[n[0]][n[1]] < n[2]) continue;
            map[n[0]][n[1]] = n[2];
            map[n[1]][n[0]] = n[2];
        }
        
        //플로이드 와샬 : 정점과 정점 사이의 최소거리를 구해주는 알고리즘
        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map.length; j++) {
                for(int k = 1; k < map.length; k++) {
                    if(map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
        
        // 1번 마을부터 출발하니, map[0]를 순환한다. 시간이 K이하면 answer++
        for(int i = 1; i < map[1].length; i++) {
            if(map[1][i] <= K) answer++;
        }

        return answer;
    }
}