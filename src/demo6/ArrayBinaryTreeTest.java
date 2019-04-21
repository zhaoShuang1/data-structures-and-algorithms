package demo6;
//顺序二叉树
public class ArrayBinaryTreeTest {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8};
		ArrayBinaryTree tree = new ArrayBinaryTree(arr);
		//前序遍历
		tree.frontShow();
	}

}
