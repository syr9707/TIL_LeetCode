import java.io.*;
import java.util.*;

class Main {

	static List<List<Integer>> graph;
	static List<Node> tree;
	static boolean[] visited;
	static int[] size;

	static class Node {
		int number;
		Node parent;
		List<Node> children = new ArrayList<>();

		public Node(int number) {
			this.number = number;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public void setChild(Node child) {
			this.children.add(child);
		}

		public List<Node> getChildren() {
			return children;
		}

		public int getNumber() {
			return number;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		tree = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			tree.add(new Node(i));
		}

		visited = new boolean[n + 1];
		size = new int[n + 1];
		graphToTree(r);
		countAllChildren(tree.get(r));

		for (int i = 0; i < q; i++) {
			int query = Integer.parseInt(br.readLine());
			System.out.println(size[query]);
		}
	}

	private static void graphToTree(int parent) {
		visited[parent] = true;
		for (Integer child : graph.get(parent)) {
			if (visited[child]) {
				continue;
			}
			tree.get(parent).setChild(tree.get(child));
			tree.get(child).setParent(tree.get(parent));
			graphToTree(child);
		}
	}

	private static void countAllChildren(Node parent) {
		size[parent.getNumber()] = 1;
		for (Node child : parent.getChildren()) {
			countAllChildren(child);
			size[parent.getNumber()] += size[child.getNumber()];
		}
	}
}