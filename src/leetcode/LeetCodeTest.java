package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeTest {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	/**
	 * 中序二叉树遍历
	 * @author zs
	 * @date 2019年4月29日
	 * @param node
	 */
	public static void show(TreeNode node) {
		if(node == null)
			return;
		show(node.left);
		System.out.println(node.val);
		show(node.right);
	}
	/**
	 * 两数之和
	 *   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * @author zs
	 * @date 2019年4月29日
	 */
	public static int[] twoSum(int[] nums,int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < nums.length ; i ++ ) {
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i}; 
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
	/**
	 * 合并二叉树
	 * @author zs
	 * @date 2019年4月29日
	 */
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
        	return null;
        int newValue = 0;
        if(t1 != null)
        	newValue += t1.val;
        if(t2 != null)
        	newValue += t2.val;
        TreeNode t = new TreeNode(newValue);
        TreeNode l = mergeTrees(t1 != null ?t1.left:null, t2 != null ? t2.left: null);
        TreeNode r = mergeTrees(t1 != null ?t1.right:null, t2 != null ? t2.right : null);
        t.left = l ;
        t.right = r;
		return t;
    }
	
	
	/**
	 * 任务调度器
	 *
	 * 假设数组 ["A","A","A","B","B","C"]，n = 2，A的频率最高，记为count = 3，所以两个A之间必须间隔2个任务，才能满足题意并且是最短时间（两个A的间隔大于2的总时间必然不是最短）
	 * ，因此执行顺序为： A->X->X->A->X->X->A，这里的X表示除了A以外其他字母，或者是待命，不用关心具体是什么，反正用来填充两个A的间隔的。
	 * 上面执行顺序的规律是： 有count - 1个A，其中每个A需要搭配n个X，再加上最后一个A，所以总时间为 (count - 1) * (n + 1) + 1
	 *	要注意可能会出现多个频率相同且都是最高的任务，比如 ["A","A","A","B","B","B","C","C"]，所以最后会剩下一个A和一个B，因此最后要加上频率最高的不同任务的个数 maxCount
	 * 公式算出的值可能会比数组的长度小，如["A","A","B","B"]，n = 0，此时要取数组的长度
	 */
	public static int leastInterval(char[] tasks,int n) {
		int[] count = new int[26];
		for(int i = 0 ; i < tasks.length ; i ++ ) {
			count[tasks[i]-'A']++;
		}
		Arrays.sort(count);
		
		int maxCount = 0 ;
		for(int i = count.length - 1 ; i >=0 ; i++) {
			if(count[i] == count[count.length-1])
				maxCount ++;
		}
		
		return Math.max((count[count.length-1]-1)*(n+1)+maxCount, tasks.length);
	}
	
	
	/**
	 * 根据一棵树的中序遍历与后序遍历构造二叉树。
	 * @author zs
	 * @date 2019年4月29日
	 */
	public static TreeNode buildTree(int[] inorder,int[] postorder) {
		return buildTree(inorder,0,inorder.length,postorder,0,postorder.length);
	}
	private static TreeNode buildTree(int[] inorder, int i, int length, int[] postorder, int j, int length2) {
		if(i==length || j ==length2)
			return null;
		TreeNode node = new TreeNode(postorder[length2-1]);
		for(int k = i ; k < length ; k ++) {
			if(inorder[k]==postorder[length2-1]) {
				node.left=buildTree(inorder, i, k, postorder, j, k-i+j);
				node.right=buildTree(inorder, k+1, length,postorder, k-i+j, length2-1);
			}
		}
		return node;
	}
	
	/**
	 * 107. 二叉树的层次遍历 II
	 * @author zs
	 * @date 2019年4月29日
	 */
	public static List<List<Integer>>  levelOrderBottom(TreeNode node){
		List<List<Integer>> list = new ArrayList<>();
		levelization(list , node, 0 );
		Collections.reverse(list);
		return list;
	}
	private static void levelization(List<List<Integer>> list,TreeNode node,int level) {
		if(node == null)
			return;
		if(list.size() == level) {
			List<Integer> l = new ArrayList<>();
			l.add(node.val);
			list.add(l);
		}else {
			List<Integer> l = list.get(level);
			l.add(node.val);
		}
		levelization(list, node.left, level+1);
		levelization(list, node.right, level+1);
	}
	
	
	/**
	 * 235. 二叉搜索树的最近公共祖先
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		
		return null;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
//		int[] nums = new int[] {2,7,11,15};
//		int[] test1 = twoSum(nums, 13);
//		System.out.println(Arrays.toString(test1));

		
//		int[] inorder = new int[] {9,3,15,20,7};
//		int[] postorder = new int[] {9,15,7,20,3};
//		
//		TreeNode tree = buildTree(inorder, postorder);
//		show(tree);
		
		
//		TreeNode t3 = new TreeNode(3);
//		TreeNode t9 = new TreeNode(9);
//		TreeNode t20 = new TreeNode(20);
//		TreeNode t15 = new TreeNode(15);
//		TreeNode t7 = new TreeNode(7);
//		
//		t3.left= t9;
//		t3.right = t20;
//		t20.left = t15;
//		t20.right = t7;
//		levelOrderBottom(t3).forEach(System.out::println);
		
	}
}
