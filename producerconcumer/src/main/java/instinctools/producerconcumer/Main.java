package instinctools.producerconcumer;

import org.apache.log4j.BasicConfigurator;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Store store = new Store(10);
		Producer producer1 = new Producer(store, "1");
		Producer producer2 = new Producer(store, "2");
		Consumer consumer3 = new Consumer(store, "3");
		Consumer consumer2 = new Consumer(store, "2");
		Consumer consumer1 = new Consumer(store, "1");
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
		new Thread(consumer1).start();
	}

}
