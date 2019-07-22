package com.somnath.apps.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MultiThreadingWithCollections {

	public static void main(String[] args) {
		final Map<String, String> unsafeMap = new HashMap<>();
		final Map<String, String> threadSafeMap = Collections.synchronizedMap(new HashMap<>());

		MyWriterThread writerThread = new MyWriterThread(unsafeMap);
		MyReaderThread readerThread = new MyReaderThread(unsafeMap);
		writerThread.start();
		readerThread.start();

		/*Thread t1 = new Thread(
				() -> {
					for(int i=0; i<5;i++){
						unsa
					}
				});
		*/
	}

	private static class MyWriterThread extends Thread {

		private final Map<String, String> map;

		public MyWriterThread(final Map<String, String> map) {
			this.map = map;
		}

		public void run() {
			try {
				for(int i=0; i<5000;i++){
					map.put("Key"+i, "Val"+i);
					System.out.println("Inserted" + "Key"+i + ", " + "Val"+i);
					//Thread.sleep(100);
				}
			//} catch (InterruptedException ex) {
			} catch (Exception ex) {
				//System.out.println("Thread " + Thread.currentThread() + " was interrupted.");
				ex.printStackTrace();
			}
		}
	}

	private static class MyReaderThread extends Thread {

		private final Map<String, String> map;

		public MyReaderThread(final Map<String, String> map) {
			this.map = map;
		}

		public void run() {
			try {
				for(int i=0; i<5000;i++){
					System.out.println("Key"+i + "= " + map.get("Key"+i));
					//Thread.sleep(1);
				}
			//} catch (InterruptedException ex) {
			} catch (Exception ex) {
				//System.out.println("Thread " + Thread.currentThread() + " was interrupted.");
				ex.printStackTrace();
			}
		}
	}
}
