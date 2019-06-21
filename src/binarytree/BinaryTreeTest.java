package binarytree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		//创建树
		BinaryTree tree = new BinaryTree();
		
		//创建节点
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.leftNode = n2;
		n1.rightNode = n3;
		n2.leftNode = n4;
		n2.rightNode = n5;
		n3.leftNode = n6;
		n3.rightNode = n7;
		
		tree.root = n1;
		
//		//前序遍历
//		tree.frontShow();
//		System.out.println("=============");
//		//中序遍历
//		tree.midShow();
//		System.out.println("=============");
//		//后序遍历
//		tree.afterShow();
//		System.out.println("=============");
//		
//		//中序搜索
//		TreeNode node2 = tree.midSearch(8);
//		System.out.println(node2);
		
		//节点删除
		tree.delete(3);
		tree.midShow();
		
		
		
	}

}
