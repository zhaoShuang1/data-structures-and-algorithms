package AVLtree;

public class BinarySortTree {
	Node root;
	
	public void add(Node node) {
		if(root==null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	
	
	public void midShow() {
		if(root != null) {
			root.midShow(root);
		}
	}
	
	
	public Node search(int value) {
		if(root != null) {
			return root.search(value);
		}
		return null;
	}
	
	public Node searchParent(int value) {
		if(root != null) {
			return root.searchParent(value);
		}
		return null;
	}
	
	
	public void delete(int value) {
		Node target = search(value);
		if(target == null) {
			return;
		}
		
		Node parent = root.searchParent(value);
		//删除的节点为叶子节点
		if(target.getLeft() == null && target.getRight() == null) {
			if(parent.getLeft().getValue()==value) {
				parent.setLeft(null);
			}else {
				parent.setRight(null);
			}
		//删除的节点左右节点都有值，找到当前节点的后继节点，并把后继节点的值赋给当前节点，同时删除后继节点
		}else if(target.getLeft() != null && target.getRight() != null) {
			//找到后继节点并删除
			int v = deleteMin(target);
			//替换目标节点的值
			target.setValue(v);
			
		}else { //删除的节点只有一个子节点有值
			if(parent.getLeft().getValue()==value) {
				if(target.getLeft() == null) { 
					parent.setLeft(target.getRight());
				}else { 
					parent.setLeft(target.getLeft());
				}
			}else {
				if(target.getLeft() == null) { 
					parent.setRight(target.getRight());
				}else { 
					parent.setRight(target.getLeft());
				}
			}
		}
	}
	
	
	
	
	/**
	 * 删除最小的节点
	 * 
	 * @return 删除的节点的值
	 */
	public int deleteMin(Node node) {
		Node target = node;
		while(target.getLeft() != null) {
			target=target.getLeft();
		}
		delete(target.getValue());
		return target.getValue(); 
	}
	
	
	
	public int height() {
		if(root==null) {
			return 0;
		}
		return root.height();
	}
}
