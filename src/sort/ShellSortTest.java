package sort;

import java.util.Arrays;

public class ShellSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {21,34,5,7,1,4,8,12,3};
		System.out.println(Arrays.toString(arr));
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void shellSort(int[] arr) {
		
		int len = arr.length;
		
		//遍历所有步长
		for(int d = len/2 ; d > 0 ; d /= 2) {
			//遍历所有元素
			for(int i = d ; i < len ; i ++) {
				//找到一个组
				for(int j = i-d ; j >= 0 ; j-=d) {
					//比较组
					if(arr[j] > arr[j+d]) {
						int temp = arr[j];
						arr[j] = arr[j+d];
						arr[j+d] = temp;
					}
				}
			}
		}
	}

}
