package instinctools.producerconcumer;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Consumer implements Runnable {

	private Store store;
	private String num;
	private Logger logger = LogManager.getLogger("Logger");

	public Consumer(Store store, String num) {
		this.store = store;
		this.num = num;
	}

	public void run() {
		while (true) {
			store.take(num);
			try {
				Thread.sleep(new Long(new Random().nextInt(4000)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//logger.info("Consumer " + num + " has taken one. Left: " + store.getCount());
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/*synchronized (this) {
				if (!store.isEmpty()) {
					store.take();
					logger.info("Consumer " + num + " has taken one. Left: " + store.getCount());
					notifyAll();
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						break;
					}
				}
			}*/
		}
	}

}
