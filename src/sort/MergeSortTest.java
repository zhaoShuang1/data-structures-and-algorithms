package sort;

import java.util.Arrays;
/**
 * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 * 时间复杂度 O(n log n) 
 * 空间复杂度 T（n)
 * 归并操作(merge)，也叫归并算法，指的是将两个顺序序列合并成一个顺序序列的方法。
	如　设有数列{6，202，100，301，38，8，1}
	初始状态：6,202,100,301,38,8,1
	第一次归并后：{6,202},{100,301},{8,38},{1}，比较次数：3；
	第二次归并后：{6,100,202,301}，{1,8,38}，比较次数：4；
	第三次归并后：{1,6,8,38,100,202,301},比较次数：4；
	总的比较次数为：3+4+4=11；
	逆序数为14
 */
public class MergeSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {21,34,5,7,1,4,8,12,3};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if(low < high) {
			int middle = (high+low)/2;
			//处理左边
			mergeSort(arr, low, middle);
			//处理右边
			mergeSort(arr, middle+1,high);
			//归并
			merge(arr, low, middle, high);
		}
	}

	public static void merge(int[] arr, int low, int middle, int high) {
		//创建一个临时数组，用来存储归并之后的临时数据
		int[] temp = new int[high-low+1];
		//临时数组的下标
		int index = 0 ;
		//第一个数组开始的下标
		int i = low;
		//第二个数组中需要遍历的下标
		int j = middle + 1;
		//遍历两个数组取出最小的元素放入临时数组中
		while(i <= middle && j <= high) {
			if(arr[i] < arr[j]) {
				temp[index++]=arr[i++];
			}else {
				temp[index++]=arr[j++];
			}
		}
		//处理未比较的数据
		while(i<=middle) {
			temp[index++]=arr[i++];
		}
		
		while(j<=high) {
			temp[index++]=arr[j++];
		}
		
		//把临时数组中的数据放回到原数组
		System.arraycopy(temp, 0, arr, low, temp.length);
	}

}
