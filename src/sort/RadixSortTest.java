package sort;

import java.util.Arrays;
/**
 * 基数排序
 *	基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，
 * 	顾名思义，它是透过键值的部份资讯，将要排序的元素分配至某些“桶”中，藉以达到排序的作用，基数排序法是属于稳定性的排序，
 * 	其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 */
public class RadixSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {21,34,5,7,1,4,8,12,3,324,182,19,46,87};
		System.out.println(Arrays.toString(arr));
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void radixSort(int[] arr) {
		//循环次数
		int max = (Arrays.stream(arr).max().getAsInt()+"").length();
		//用于存储临时数据
		int[][] temp = new int[10][arr.length];
		//临时下标
		int[] count = new int[10];
		//循环比较
		for(int i = 0,n = 1 ; i < max ; i ++,n *= 10 ) {
			//遍历数据
			for(int j = 0 ; j < arr.length ; j ++ ) {
				//找到余数
				int k = arr[j]/n%10;
				temp[k][count[k]++]=arr[j];
			}
			int index = 0;
			//取出元素
			for(int k = 0 ; k < count.length ; k ++) {
				if(count[k] != 0)
					for(int j = 0 ; j < count[k] ; j ++) {
						arr[index++] = temp[k][j];
					}
				count[k]=0;
			}
		}
	}

}
