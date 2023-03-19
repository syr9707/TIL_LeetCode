import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();

        List<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(first);
        Deque<Integer> queue1 = new ArrayDeque<>();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());;
        int K=Integer.parseInt(st.nextToken());;
        int X=Integer.parseInt(st.nextToken());;

        int[] vitsted = new int[N];
        Deque<Integer>[] nodes = new Deque[N];

        for(int i=0; i<N;i++){
            nodes[i]=new ArrayDeque<>();
        }

        for(int i=0; i<N;i++){
            vitsted[i]=-1;
        }

        for(int i=0;i<M;i++){
            String s = br.readLine();
            st=new StringTokenizer(s);
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            nodes[a-1].add(b-1);
        }

        queue1.offer(X-1);
        vitsted[X-1]++;
        while (!queue1.isEmpty()){
            int index = queue1.poll();
            for(int item : nodes[index]){
                if(vitsted[item]==-1){
                    vitsted[item]=vitsted[index]+1;
                    queue1.offer(item);
                }
            }
        }

        for(int i=0;i<N;i++){
            if(vitsted[i]==K)
                answer.add(i+1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Collections.sort(answer,Comparator.naturalOrder());

        if(answer.isEmpty())
            bw.write("-1");
        else{
            for(int item:answer){
                bw.write(Integer.toString(item));
                bw.newLine();
            }

        }
        bw.flush();
        bw.close();

        return;

    }

}
