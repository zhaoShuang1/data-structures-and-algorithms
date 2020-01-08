package leetcode;

import java.util.concurrent.TimeUnit;

/**
 * 我们提供一个类：
 * 
 * class FooBar { public void foo() {     for (int i = 0; i < n; i++) {      
 * print("foo");   } }
 * 
 * public void bar() {     for (int i = 0; i < n; i++) {       print("bar");    
 * } } } 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * 
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author zs
 * @date 2020年1月8日
 */
public class PrintFooBarAlternately {
	static class FooBar {
	    private int n;
	    volatile boolean mark;

	    public FooBar(int n) {
	        this.n = n;
	    }

	    public void foo(Runnable printFoo) throws InterruptedException {
	        
	        for (int i = 0; i < n; i++) {
	            while(mark) {TimeUnit.MILLISECONDS.sleep(0);}
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	        	mark=true;
	        }
	    }

	    public void bar(Runnable printBar) throws InterruptedException {
	        
	        for (int i = 0; i < n; i++) {
	        	 while(!mark) {TimeUnit.MILLISECONDS.sleep(0);}
	            // printBar.run() outputs "bar". Do not change or remove this line.
	        	printBar.run();
	        	mark=false;
	        }
	    }
	}
	
	public static void main(String[] args) {
		FooBar fooBar = new FooBar(4);
		new Thread(()->{
			try {
				fooBar.foo(()->{System.out.println("foo");});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
				fooBar.bar(()->{System.out.println("bar");});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();;
	}
}
