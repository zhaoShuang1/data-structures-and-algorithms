package leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。
 * 
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * 
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * 
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * 
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * 
 * 换句话说:
 * 
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。 书写满足这些限制条件的氢、氧线程同步代码。
 * 
 *  
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/building-h2o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author zs
 * @date 2020年1月8日
 */
public class BuildingH2o {
	static class H2O {
		CyclicBarrier barrier = new CyclicBarrier(3);
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(2);
		
	    public H2O() {
	        
	    }

	    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
	    	
	    	s2.acquire();
	        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
	        releaseHydrogen.run();
	        try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        s2.release();
	    }

	    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
	    	s1.acquire();
	    	// releaseOxygen.run() outputs "O". Do not change or remove this line.
			releaseOxygen.run();
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s1.release();
	    }
	    
	}
	
	public static void main(String[] args) throws InterruptedException {
		H2O h2o = new H2O();
		for(int i  = 0 ; i < 2 ; i ++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						h2o.oxygen(new Runnable() {
							public void run() {	
								System.out.println("O");
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		for(int i  = 0 ; i < 4 ; i ++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						h2o.hydrogen(new Runnable() {
							public void run() {	
								System.out.println("H");
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		Semaphore s = new Semaphore(0);
		new Thread(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				s.release(2);
			}
		}).start();
		s.acquire(2);
		
		System.out.println("done");
		
		
	}
}
