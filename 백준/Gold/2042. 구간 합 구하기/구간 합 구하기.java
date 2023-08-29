import java.io.*;
import java.util.*;

public class Main {
    
	static long nums[], tree[];
	static int N, M, K, S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		nums= new long[N];
		
		for(int i=0; i<N; i++) {
			nums[i]= Long.parseLong(br.readLine());
		}
		
		S=1;
		while(S<N) {
			S*=2;
		}
		tree= new long[S*2];
		
		initBU();
		
		int a, b;
		long c;
		for(int i=0; i<M+K; i++) {
			st= new StringTokenizer(br.readLine());
			a= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			c= Long.parseLong(st.nextToken());
			
			if(a==1) {
				update(1, S, 1, b, c-nums[b-1]);
				nums[b-1]=c;
			}else if(a==2) {
				System.out.println(query(1, S, 1, b, c));
			}
		}
		
	}
	
	static void initBU() {
		for(int i=0; i<N; i++) {
			tree[S+i]=nums[i];
		}
        
		for(int i=S-1; i>0; i--) {
			tree[i]= tree[i*2]+tree[i*2+1];
		}
	}
	
	static long query(int left, int right, int node, int queryLeft, long queryRight) {
		if(right<queryLeft||queryRight<left) {
			return 0;
		} else if(queryLeft<=left&&right<=queryRight) {
			return tree[node];
		} else {
			int mid= (left+right)/2;
			long leftResult= query(left, mid, node*2, queryLeft, queryRight);
			long rightResult= query(mid+1, right, node*2+1, queryLeft, queryRight);
			return leftResult+rightResult;
		}
	}
    
	static void update(int left, int right, int node, int target, long diff) {
		if(target<left||right<target) return;
		tree[node]+=diff;
		if(left!=right) {
			int mid= (left+right)/2;
			update(left, mid, node*2, target, diff);
			update(mid+1, right, node*2+1, target, diff);
		}
	}
}