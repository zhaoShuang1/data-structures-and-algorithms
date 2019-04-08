package sort;

import java.util.Arrays;
/**
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。	
 * 
 * 冒泡排序最好的时间复杂度为 O(n)，最坏时间复杂度为O(n^2)
 * 
 */
public class BubbleSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {21,34,5,7,1,4,8,12,3};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		for(int i = 0 ; i < arr.length-1 ; i ++) {
			for(int j = 0 ; j < arr.length-1-i ; j ++ ) {
				//比较相邻的两个元素，如果当前元素大于下一个元素则交换位置
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}
}
