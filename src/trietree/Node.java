package trietree;

import java.util.LinkedList;
import java.util.List;

public  class Node {
	char value; //权值
	boolean isEnd; //是否为结束节点
	List<Node> children; //所有子节点
	public Node(char value) {
		this.value = value;
		this.isEnd = false;
		this.children = new LinkedList<>();
	}
	public Node findNode(char c) {
		return children.stream().filter((n)->{return n.value==c;}).findFirst().orElse(null);
	}
	
		
}