package sort;

import java.util.Arrays;
/**
 * 选择排序
 * 选择排序是给每个位置选择当前元素最小的，比如给第一个位置选择最小的，在剩余元素里面给第二个元素选择第二小的，
 * 依次类推，直到第n-1个元素，第n个元素不用选择了，因为只剩下它一个最大的元素了。
 * 那么，在一趟选择，如果一个元素比当前元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么交换后稳定性就被破坏了。
 * 比较拗口，举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，那么原序列中两个5的相对前后顺序就被破坏了，
 * 所以选择排序是一个不稳定的排序算法。
 * 
 * 
 * 
 */
public class SelectSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {21,34,5,7,1,4,8,12,3};
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectSort(int[] arr) {
		int minIndex = 0;
		int temp = 0;
		for(int i = 0 ; i < arr.length ; i ++ ) {
			minIndex = i;
			for(int j = i+1 ; j < arr.length ; j ++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if(minIndex!=i) {
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex]=temp;
			}
		}
	}
}
