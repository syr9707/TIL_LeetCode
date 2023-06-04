import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(maxPQ.size() == minPQ.size()) {
				maxPQ.add(num);
				
				if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
					minPQ.add(maxPQ.poll());
					maxPQ.add(minPQ.poll());
				}
			} else {
				minPQ.add(num);
				
				if(maxPQ.peek() > minPQ.peek()) {
					minPQ.add(maxPQ.poll());
					maxPQ.add(minPQ.poll());
				}
			}
			
			sb.append(maxPQ.peek() + "\n");
		}
		
		System.out.println(sb);

	}

}