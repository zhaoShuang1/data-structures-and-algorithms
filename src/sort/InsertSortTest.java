package sort;

import java.util.Arrays;

/**
 * https://www.codelike.in/animation/search-sort
 * 插入排序的基本思想是：每步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
 * 时间复杂度
 */
public class InsertSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {21,34,5,7,1,4,8,12,3};
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr) {
		for(int i = 1 ; i < arr.length ; i ++) {
			for(int j = i ; j > 0 ; j --) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	}
}
