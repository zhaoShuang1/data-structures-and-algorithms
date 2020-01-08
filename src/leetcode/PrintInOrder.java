package leetcode;

/**
 * https://leetcode-cn.com/problems/print-in-order/ 三个不同的线程将会共用一个 Foo 实例。
 * 
 * 线程 A 将会调用 one() 方法 线程 B 将会调用 two() 方法 线程 C 将会调用 three() 方法 请设计修改程序，以确保 two()
 * 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author zs
 * @date 2020年1月8日
 */
public class PrintInOrder {
	public static class Foo {
		volatile boolean firstMarker = false;
		volatile boolean secondMarker = false;

		Foo() {

		}

		public void first(Runnable printFirst) throws InterruptedException {
			// printFirst.run() outputs "first". Do not change or remove this line.
			printFirst.run();
			firstMarker = true;
		}

		public void second(Runnable printSecond) throws InterruptedException {
			while (!firstMarker) {
			}
			// printSecond.run() outputs "second". Do not change or remove this line.
			printSecond.run();
			secondMarker = true;
		}

		public void third(Runnable printThird) throws InterruptedException {
			while (!secondMarker) {
			}
			// printThird.run() outputs "third". Do not change or remove this line.
			printThird.run();
		}

	}

}
