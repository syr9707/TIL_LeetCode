import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayDeque<Integer> deque;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {

			String p = br.readLine();
			int number = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			deque = new ArrayDeque<Integer>();

			for(int i=0; i<number; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			AC(p);
		}

		System.out.println(sb);
	} // End of main

	static void AC(String p) {
		boolean forward_direction = true;

		for(char function : p.toCharArray()) {

			if(function == 'R') {
				forward_direction = !forward_direction;
				continue;
			}

			// 정방향일 때
			if( forward_direction ) {

				// 덱이 비었으면,
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			}
			// 역방향 일때 forward_direction = true
			else {

				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}

		makePrintString(forward_direction);
	}

	private static void makePrintString(boolean forward_direction) {

		sb.append('[');

		if(deque.size() > 0) {
			if(forward_direction) {
				sb.append(deque.pollFirst());

				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {
				sb.append(deque.pollLast());

				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}

		sb.append(']').append('\n');
	} 

}
