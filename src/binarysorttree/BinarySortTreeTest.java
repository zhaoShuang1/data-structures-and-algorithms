package binarysorttree;

/**
   * 二叉排序树
 */
public class BinarySortTreeTest {
	public static void main(String[] args) throws Exception {
		BinarySortTree binarySortTree = new BinarySortTree();
		int[] arr = new int[] {7,3,10,12,5,1,8};
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
		//不正常
		byte[] bytes = "‭13789760762‬".getBytes();
		//正常
		byte[] bytes2 = "13789760762‬".getBytes();
		byte[] b = new byte[3];
		byte[] b2= new byte[bytes2.length-3];
		byte[] b1 = new byte[] {-30,-128,-84};
		
		
		
		
		System.arraycopy(bytes, 0, b, 0, 3);
		
		System.arraycopy(bytes2, 0, b2, 0, bytes2.length-3);
		
		System.out.println(new String(b2,"utf-8"));
		
		System.out.println("-----");
		System.out.println(new String(b1,"utf-8"));
		
		for (byte c : b) {
			System.out.println(Integer.toBinaryString(c));
		}
		
		
	}

}










