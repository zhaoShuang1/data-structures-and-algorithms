package demo5;

public class TreeNode {
	//权值
	int value;
	//左节点
	TreeNode leftNode;
	//右节点
	TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value = value;
	}
	/**
	 * 前序遍历
	 */
	public void frontShow() {
		System.out.println(value);
		if(leftNode != null) {
			leftNode.frontShow();
		}
		if(rightNode != null) {
			rightNode.frontShow();
		}
	}
	
	//中序遍历
	public void midShow() {
		if(leftNode != null) {
			leftNode.midShow();
		}
		System.out.println(value);
		if(rightNode != null) {
			rightNode.midShow();
		}
	}
	//后序遍历
	public void afterShow() {
		if(leftNode != null) {
			leftNode.afterShow();
		}
		if(rightNode != null) {
			rightNode.afterShow();
		}
		System.out.println(value);
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
	
	
	/**
	 * 中序搜索
	 */
	public TreeNode midSearch(int i) {
		TreeNode  target = null;
		if(leftNode != null) {
			target = leftNode.midSearch(i);
			if(target != null)
				return target;
		}
		if(value == i) {
			return this;
		}
		
		if(rightNode != null) {
			target = rightNode.midSearch(i);
			if(target != null)
				return target;
		}
		return null;
	}
	
	//删除子树
	public void delete(int i) {
		if(leftNode != null && leftNode.value == i) {
			leftNode = null;
			return;
		}
		if(rightNode != null && rightNode.value == i) {
			rightNode = null;
			return;
		}
		
		if(leftNode != null) {
			leftNode.delete(i);
		}
		
		if(rightNode != null) {
			rightNode.delete(i);
		}
	}
	
	
	
	
	
}
