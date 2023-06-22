import java.io.*;
import java.util.*;

public class Main {
 
    static int N, M, K, food[][], add[][];
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static Queue<Tree> trees;
    static class Tree implements Comparable<Tree>{
        int x, y, age;
 
        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
 
        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
            
        food = new int[N][N];
        add = new int[N][N];
        trees = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                food[i][j] = 5;
                add[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken());
            
            trees.add(new Tree(x, y, a));
        }
        
        Collections.sort((List<Tree>) trees);
        
        System.out.println(process());
    }
 
    private static int process() {
        
        while(K-- > 0) {
            springToSummer();
            fall();
            winter();
        }
        
        return trees.size();
    }
 
    private static void winter() {
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                food[i][j] += add[i][j];
            }
        }
        
    }
 
    private static void fall() {
 
        ArrayList<Tree> parents = new ArrayList<>();
        
        int size = trees.size();
        while (size-- > 0) {
            
            Tree now = trees.poll();
            
            if(now.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int xx = now.x + dx[d];
                    int yy = now.y + dy[d];
                    
                    if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                    
                    trees.add(new Tree(xx, yy, 1));
                }
            }
            
            parents.add(now);
        }
        
        for (Tree t : parents) {
            trees.add(t);
        }
    }
 
    private static void springToSummer() {
        ArrayList<Tree> die = new ArrayList<>();
        
        int size = trees.size();
        while (size -- > 0) {
            Tree now = trees.poll();
            
            if(food[now.x][now.y] - now.age < 0) {
                die.add(new Tree(now.x, now.y, now.age / 2));
            } else {
                food[now.x][now.y] -= now.age;
                trees.add(new Tree(now.x, now.y, now.age + 1));
            }        
        }
        
        for (Tree t : die) {
            food[t.x][t.y] += t.age;
        }
    }
    
}
