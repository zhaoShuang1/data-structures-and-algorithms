package trietree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieTree {
	private Node root;
	public TrieTree() {
		root = new Node('/');
	}
	
	
	
	
	public void insert(String str) {
		if(str == null || str.length() == 0)
			return;
		Node currentNode = root;
		char[] charArray = str.toCharArray();
		
		for(int i = 0 ; i < str.length() ; i ++ ) {
			char c = charArray[i];
			Node node = currentNode.findNode(c);
			if(node == null) {
				Node n = new Node(c);
				currentNode.children.add(n);
				currentNode = n;
			}else {
				currentNode = node;
			}
		}
		currentNode.isEnd=true;
	}
	
	public boolean search(String str) {
		if(str == null || str.length() == 0)
			return false;
		
		char[] charArray = str.toCharArray();
		Node currentNode = root;
		for (char c : charArray) {
			Node node = currentNode.findNode(c);
			if(node == null) {
				return false;
			}else {
				currentNode = node;
			}
		}
		return currentNode.isEnd;
	}
	
	
	public void prefix(String str){
		char[] arr = str.toCharArray();
		Node currentNode = root;
		for (char c : arr) {
			Node node = currentNode.findNode(c);
			currentNode=node;
			if(node == null) {
				return;
			}
		}
		
		preTraverse(currentNode,str);
	}
	
	private void preTraverse(Node node, String str) {
		if (!node.isEnd) {
			for (Node c : node.children) {
				preTraverse(c, str+c.value);
			}
        }
		System.out.println(str);
	}
	
	
	public void delete(String str) {
		char[] arr = str.toCharArray();
		Node currentNode = root;
		List<Node> traces = new ArrayList<>();
		for (char c : arr) {
			Node node = currentNode.findNode(c);
			if(node == null) {
				return;
			}else {
				traces.add(node);
				if(arr[arr.length-1]==node.value && node.isEnd) {
					if(node.children.size() != 0) {
						node.isEnd=false;
					}else {
						for(int i = traces.size()-1 ; i > 0 ; i --) {
							Node p = i==0?root:traces.get(i-1);
							Node t = traces.get(i);
							if(t.children.size() == 0&&!t.isEnd) {
								p.children.remove(t);
							}
						}
					}
				}
				currentNode=node;
			}
		}
	}
	
	
	
	public Map<String,Integer> tokenizer(String content){
		if(content == null || content.length() == 0)
			return Collections.emptyMap();
		Map<String,Integer> result = new HashMap<String,Integer>();
		StringBuilder sb = new StringBuilder();
		String word = null;
		Node currentNode = root;
		char[] arr = content.toCharArray();
		int idx = 0;
		
		for(int i = 0; i < arr.length ; i ++) {
			Node node = currentNode.findNode(arr[i]);
			if(node != null) {
				sb.append(node.value);
				currentNode = node;
				if(node.isEnd) {
					word = sb.toString();
					idx=i;
				}
			}else {
				if(word != null) {
					Integer count = result.get(word);
					if(count != null) {
						result.put(word, count+1);
					}else {
						result.put(word, 1);
					}
					sb = new StringBuilder();
					i=idx;
					word=null;
					currentNode = root;
				}
			}
		}
		if(word != null) {
			Integer count = result.get(word);
			if(count != null) {
				result.put(word, count+1);
			}else {
				result.put(word, 1);
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		TrieTree tree = new TrieTree();
        tree.insert("北京");
        tree.insert("海淀区");
        tree.insert("中国");
        tree.insert("中国人民");
        tree.insert("中关村");

        String word = "中国";
        //查找该词是否存在 Trid Tree 中
        boolean flag = tree.search(word);
        if(flag){
            System.out.println("Trie Tree 中已经存在【"+word+"】");
        }else{
            System.out.println("Trie Tree 不包含【"+word+"】");
        }
        
        Map<String, Integer> map = tree.tokenizer("中国人民，中国首都是北京，中关村在海淀区,中国北京天安门。中国人");
        map.forEach((k,v)->{
        	System.out.println( k + "  " + v);
        });
        word = "中国人民";
        tree.delete(word);
        flag = tree.search(word);
        if(flag){
            System.out.println("Trie Tree 中已经存在【"+word+"】");
        }else{
            System.out.println("Trie Tree 不包含【"+word+"】");
        }
        
        word="中国";
        flag = tree.search(word);
        if(flag){
            System.out.println("Trie Tree 中已经存在【"+word+"】");
        }else{
            System.out.println("Trie Tree 不包含【"+word+"】");
        }
        
	}
	
}
