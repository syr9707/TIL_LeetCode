import java.io.*;
import java.util.*;

public class Main {

	static class TrieNode{
        
		Map<String, TrieNode> childNode = new HashMap<>();
		
		TrieNode(){
			/* no-op */ 
		}
		
		public void insert(String strs) {
			TrieNode trieNode = this;
			String[] str = strs.split(",");
			for(String s : str) {
				trieNode.childNode.putIfAbsent(s, new TrieNode());
				trieNode = trieNode.childNode.get(s);
			}
		}
		
		public void print(TrieNode cur, int depth) {
			TrieNode trieNode = cur;
			if(trieNode.childNode !=null) {
				List<String> list = new ArrayList<>(trieNode.childNode.keySet());
				Collections.sort(list);
				for(String str : list) {
					for(int i=0; i<depth; i++) {
						System.out.print("--");
					}
					System.out.println(str);
					print(trieNode.childNode.get(str), depth+1);
				}
			}
		}
	}
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TrieNode trie = new TrieNode();
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			
			StringBuilder sb = new StringBuilder();
			for(int j=1; j<k+1; j++) {
				sb.append(input[j]+",");
			}
			
			trie.insert(sb.toString());
		}
		
		trie.print(trie,0);
	}
}