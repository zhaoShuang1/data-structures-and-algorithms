package binarytree;

public class BinaryTree {
	TreeNode root;

	public void frontShow() {
		if(root != null) {
			root.frontShow();
		}
	}

	public void midShow() {
		if(root != null) {
			root.midShow();
		}
	}

	public void afterShow() {
		if(root != null) {
			root.afterShow();
		}
	}


	public TreeNode midSearch(int i) {
		if(root != null) {
			return root.midSearch(i);
		}
		return null;
	}

	public void delete(int i) {
		if(root != null) {
			if(root.value==i) {
				root = null;
				return;
			}
			root.delete(i);
		}
	}


}
