package instinctools.producerconcumer;

import java.util.Random;

import javax.swing.plaf.SliderUI;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Producer implements Runnable {

	private Store store;
	private String num;
	private Logger logger = LogManager.getLogger("Logger");

	public Producer(Store store, String num) {
		this.store = store;
		this.num = num;
	}

	public void run() {
		while (true) {
			store.put(num);
			try {
				Thread.sleep(new Long(new Random().nextInt(4000)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//logger.info("Producer " + num + " has put one. Left: " + store.getCount());
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/*synchronized (this) {
				if (!store.isFull()) {
					store.put();
					logger.info("Producer " + num + " has put one. Left: " + store.getCount());
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
