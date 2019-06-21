package AVLtree;

public class Node {
	private int value;
	private Node right;
	private Node left;
	
	public Node(int value) {
		this.value=value;
	}
	
	public int height() {
		return Math.max(left != null ? left.height():0,
				right != null ? right.height():0)+1;
	}
	
	public int rightHeight() {
		if(right==null) {
			return 0;
		}
		return right.height();
	}
	
	public int leftHeight() {
		if(left==null) {
			return 0;
		}
		return left.height();
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
		
		if(leftHeight() - rightHeight() >= 2) { // 左左，右旋
			 if(left.leftHeight() < left.rightHeight()) {  //双旋转
				 left.leftRotation();
				 rightRotation();
			 }else {
				 rightRotation();
			 }
		}
		
		if(leftHeight() - rightHeight() <= -2) { // 右右，左旋
			if(right.rightHeight() < right.leftHeight()) {
				right.rightHeight();
			}
			leftRotation();
		}
		
		
	}
	
	//左旋
	private void leftRotation() {
		Node leftRight = new Node(value);
		
		leftRight.left=left;
		
		leftRight.right =right.left;
		
		value=right.value;
		
		right=right.right;
		
		left=leftRight;
	}
	
	//右旋
	private void rightRotation() {
		//创建一个新的节点，节点的值等于当前的值
		Node newRight = new Node(value);
		//把新节点的右子树设置为当前节点的右子树
		newRight.right=right;
		//把新节点的左子树设置为当前节点的左子树的右子树
		newRight.left=left.right;
		//把当前节点的值设置为左子树
		value=left.value;
		//把当前节点的左子树设置为当前节点的左子树的左子树
		left=left.left;
		//把当前节点的右子树设置为新节点
		right=newRight;
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
