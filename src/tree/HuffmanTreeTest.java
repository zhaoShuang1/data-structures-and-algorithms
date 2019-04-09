package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeTest {
	public static void main(String[] args) {
		int[] arr = new int[] {2,6,15,5,19,28,32,8,20};
		Node node = createHuffmanTree(arr);
		System.out.println(node);
	}
	
		
	public static Node createHuffmanTree(int[] arr) {
		List<Node> nodes = new ArrayList<>();
		for (int i : arr) {
			nodes.add(new Node(i));
		}
		while(nodes.size()>1) {
			Collections.sort(nodes);
			Node rightNode = nodes.get(nodes.size()-1);
			Node leftNode = nodes.get(nodes.size()-2);
			Node node = new Node(rightNode.value+leftNode.value);
			node.leftNode=leftNode;
			node.rightNode=rightNode;
			nodes.remove(rightNode);
			nodes.remove(leftNode);
			nodes.add(node);
		}
		
		return nodes.get(0);
	}
	
	
	
	
	 static class Node implements Comparable<Node>{
		private int value;
		private Node rightNode;
		private Node leftNode;
		Node(int value){
			this.value=value;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		@Override
		public int compareTo(Node o) {
			return o.value-this.value;
		}
		
	}
}


