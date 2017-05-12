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
				e.printStackTrace();
			}
		}
	}

}
