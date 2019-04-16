package demo11;

public class Node {
	private int value;
	private Node right;
	private Node left;
	
	public Node(int value) {
		this.value=value;
	}

	public void add(Node node) {
		if(node == null)
			return;
		if(this.value > node.value) {
			if(this.left == null) {
				this.left = node;
			}else {
				left.add(node);
			}
		}else {
			if(this.right==null) {
				this.right=node;
			}else {
				right.add(node);
			}
		}
	}

	public void midShow(Node node) {
		if(node == null){
			return;
		}
		midShow(node.left);
		System.out.println(node.value);
		midShow(node.right);
	}

	public Node search(int value) {
		if(this.value==value) {
			return this;
		}
		
		if(this.value > value) {
			if(this.left != null) {
				return this.left.search(value);
			}
		}else {
			if(this.right != null) {
				return this.right.search(value);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public Node searchParent(int value) {
		if((this.left != null && this.left.value == value) || 
				(this.right != null && this.right.value == value  )) {
			return this;
		}
		if(this.left != null && this.value > value ) {
			return this.left.searchParent(value);
		}else  if (this.right != null && this.value < value ){
			return this.right.searchParent(value);
		}
		return null;
	}
	
	
	
	
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	

}
