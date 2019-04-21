package sort;

import java.util.Arrays;

public class HeapSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {21,34,5,7,1,4,8,12,3};
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void heapSort(int[] arr) {
		//开始节点为最后一个非叶子节点
		int start = (arr.length-2)/2;
		//调整为大顶堆
		for(int i = start ; i >= 0 ; i --) {
			maxHeap(arr, arr.length, i);
		}
		//把数组中的第一位和最后一位交换位置，同时在把前边的数据处理为大顶堆
		for(int i = arr.length-1 ; i > 0 ; i --) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeap(arr, i, 0);
		}
	}
	
	public static void maxHeap(int[] arr,int size,int index) {
		//左子节点
		int leftNode = 2*index+1;
		//右子节点
		int rightNode = 2*index+2;
		
		//找出最大值
		int max = index;
		if(leftNode < size && arr[leftNode] > arr[max]) {
			max = leftNode;
		}
		if(rightNode < size && arr[rightNode] > arr[max]) {
			max = rightNode;
		}
		
		//交换位置
		if(max != index) {
			int temp = arr[max];
			arr[max] = arr[index];
			arr[index] = temp;
			//交换之可能会破坏大顶堆，递归处理
			maxHeap(arr, size, max);
		}
	}
}
