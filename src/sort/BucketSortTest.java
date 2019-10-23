package sort;

import java.util.Arrays;

public class BucketSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] { 21, 34, 5, 7, 1, 4, 8, 12, 3 };
		System.out.println(Arrays.toString(arr));
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bucketSort(int[] arr) {

	}

	public static void basket(int data[])// data为待排序数组
	{
		int n = data.length;
		int bask[][] = new int[10][n];
		int index[] = new int[10];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = max > (Integer.toString(data[i]).length()) ? max : (Integer.toString(data[i]).length());
		}
		String str;
		for (int i = max - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				str = "";
				if (Integer.toString(data[j]).length() < max) {
					for (int k = 0; k < max - Integer.toString(data[j]).length(); k++)
						str += "0";
				}
				str += Integer.toString(data[j]);
				bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = data[j];
			}
			int pos = 0;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < index[j]; k++) {
					data[pos++] = bask[j][k];
				}
			}
			for (int x = 0; x < 10; x++)
				index[x] = 0;
		}
	}

	// 针对c数组的大小，优化过的计数排序
	public static class CountSort {
		public static void main(String[] args) {
			// 排序的数组
			int a[] = { 100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95 };
			int b[] = countSort(a);
			for (int i : b) {
				System.out.print(i + "");
			}
			System.out.println();
		}

		public static int[] countSort(int[] a) {
			int b[] = new int[a.length];
			int max = a[0], min = a[0];
			for (int i : a) {
				if (i > max) {
					max = i;
				}
				if (i < min) {
					min = i;
				}
			} // 这里k的大小是要排序的数组中，元素大小的极值差+1
			int k = max - min + 1;
			int[] c = new int[k];
			for (int i = 0; i < a.length; ++i) {
				c[a[i] - min] += 1;// 优化过的地方，减小了数组c的大小
			}
			for (int i = 1; i < c.length; ++i) {
				c[i] = c[i] + c[i - 1];
			}
			for (int i = a.length - 1; i >= 0; --i) {
				b[--c[a[i] - min]] = a[i];// 按存取的方式取出c的元素
			}
			return b;
		}
	}
}
