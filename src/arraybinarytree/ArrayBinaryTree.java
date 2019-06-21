package arraybinarytree;
/**
 * 顺序二叉树
 *
 */
public class ArrayBinaryTree {
	int [] data;
	
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}
	
	public void frontShow() {
		frontShow(0);
	}
	/**
	 * 前序遍历
	 */
	public void frontShow(int index) {
		if(data == null || data.length == 0)
			return;
		
		System.out.println(data[index]);
		
		//左子树
		if(index*2+1 < data.length) {
			frontShow(index*2+1);
		}
		//右子树
		if(index*2+2 < data.length) {
			frontShow(index*2+2);
		}
	}

}
