package leetcode;

/**
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第
 * h 层，则该层包含 1~ 2h 个节点。
 * 
 * 示例:
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 
 * @author zs
 * @date 2020年1月9日
 */
public class CountCompleteTreeNodes {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(10);
		TreeNode n5 = new TreeNode(10);
		TreeNode n6 = new TreeNode(10);

		root.right = n1;
		root.left = n2;
		root.right.right = n3;
		root.right.left = n4;
		// root.left.right = n5;
		root.left.left = n6;
		int countNodes = new CountCompleteTreeNodes().countNodes(root);
		System.out.println(countNodes);
	}
}