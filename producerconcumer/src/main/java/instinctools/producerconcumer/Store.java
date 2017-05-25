package instinctools.producerconcumer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


//Можно было создать интерфейс хранилища с методами take put, и передавать в Consumer и Producer по интерфейсу.
public class Store { //Single Responsibility Principle выполнен

	private volatile Integer count;
	private Logger logger = LogManager.getLogger("Logger");

	public int getCount() {
		return count;
	}

	public Store(int count) {
		this.count = count;
	}

	public void take(String num) {
		synchronized (this) {
			if (isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				count=count-1;
				logger.info("Consumer " + num + " has taken one. Left: " + count);
				this.notify();
			}
		}
	}

	public void put(String num) {
		synchronized (this) {
			if (isFull()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				count=count+1;
				logger.info("Producer " + num + " has put one. Left: " + count);
				this.notify();
			}
		}
	}

	public boolean isFull() {
		if (count >= 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (count <= 5) {
			return true;
		} else {
			return false;
		}
	}
}
