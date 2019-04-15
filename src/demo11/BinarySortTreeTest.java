package demo11;
/**
   * 二叉排序树
 */
public class BinarySortTreeTest {
	public static void main(String[] args) {
		BinarySortTree binarySortTree = new BinarySortTree();
		int[] arr = new int[] {7,3,10,12,5,1,8};
		//添加节点
		for (int i : arr) {
			binarySortTree.add(new Node(i));
		}
		//中序遍历
		binarySortTree.midShow();
		//节点查找
		Node node = binarySortTree.search(12);
		System.out.println(node);
		// 父节点查找
		Node node2 = binarySortTree.searchParent(11);
		System.out.println(node2);
		System.out.println("=======");
		//节点删除
		binarySortTree.delete(8);
		binarySortTree.midShow();
		System.out.println("========");
		binarySortTree.delete(10);
		binarySortTree.midShow();
		
	}

}
