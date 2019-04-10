package sort;

import java.util.Arrays;

public class BinarySortTest {
	public static void main(String[] args) {
		
		
		int[] arr = new int[] { 21, 34, 5, 7, 1, 4, 8, 12, 3 };
		System.out.println(Arrays.toString(arr));
		binarySort2(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	
	public static void swap(int a , int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	/**
	 * 	固定位置切分
	 * 
	 */
	public static void binarySort1(int []array,int low,int high){
		if(low < high) {
	        int key=array[low];
	        int start = low;
	        int end = high;
	        while(start<end){
	            while(array[end]>key&&end>start){
	                end--;
	            }
	            array[start]=array[end];
	            while(array[start]<key&&end>start){
	                start++;
	            }
	            array[end]=array[start];
	        }
	        array[end]=key;
	        binarySort1(array, low, start);
	        binarySort1(array, start+1, high);
		}
    }
    
	
	
	/**
	 * 中间位置切分
	 */
	public static void binarySort2(int []array,int low,int high){
		
		if(low < high) {
			int mid = (low+high)/2;
			int temp = array[low];
			array[low] = array[mid];
			array[mid]=temp;
			int key = array[low];
	        int start = low;
	        int end = high;
	        while(start<end){
	            while(array[end]>key&&end>start){
	                end--;
	            }
	            array[start]=array[end];
	            while(array[start]<key&&end>start){
	                start++;
	            }
	            array[end]=array[start];
	        }
	        array[end]=key;
	        System.out.println(Arrays.toString(array));
	        binarySort1(array, low, start);
	        binarySort1(array, start+1, high);
		}
	}
	
	
	
}
