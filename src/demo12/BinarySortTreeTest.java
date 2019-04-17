package demo12;
/**
   * 二叉排序树
 */
public class BinarySortTreeTest {
	public static void main(String[] args) {
		BinarySortTree binarySortTree = new BinarySortTree();
		//int[] arr = new int[] {7,3,10,12,5,1,8};
		//int[] arr = new int[] {1,2,3,4,5,6,7,8};
//		int[] arr = new int[] {7,5,8,6,4,3};
		int[] arr = new int[] {7,8,4,3,5,6};
		//添加节点
		for (int i : arr) {
			binarySortTree.add(new Node(i));
		}
		//中序遍历
		binarySortTree.midShow();
//		//节点查找
//		Node node = binarySortTree.search(12);
//		System.out.println(node);
//		// 父节点查找
//		Node node2 = binarySortTree.searchParent(11);
//		System.out.println(node2);
//		System.out.println("=======");
//		//节点删除
//		binarySortTree.delete(8);
//		binarySortTree.midShow();
//		System.out.println("========");
//		binarySortTree.delete(10);
//		binarySortTree.midShow();
		
//		System.out.println("-----");
//		binarySortTree.delete(3);
//		binarySortTree.midShow();
		
		//树的高度
		System.out.println(binarySortTree.height());
		
		
		System.out.println(binarySortTree.root.rightHeight());
		System.out.println(binarySortTree.root.leftHeight());
		
		System.out.println(binarySortTree.root);
		System.out.println(binarySortTree.root.getLeft());
		System.out.println(binarySortTree.root.getRight());
	}

}
