package demo11;

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
		//删除的节点左右节点都有值
		}else if(target.getLeft() != null && target.getRight() != null) {
			
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
	
	

}
