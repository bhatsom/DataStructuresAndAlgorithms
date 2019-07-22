package com.somnath.apps.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

	public static void main(String[] args) {
		usingFixedThreadPool();

	}

	private static void usingFixedThreadPool() {
		// below returns an instance of ThreadPoolExecutor wrapped by a FinalizableDelegatedExecutorService
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

		try {
			// below returns an instance of ThreadPoolExecutor
			ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

			Runnable myRunnable = () -> {
				try {
					System.out.println("Inside myRunnable. Going to sleep for 3 seconds..");
					TimeUnit.SECONDS.sleep(3);
					System.out.println("myRunnable is Done!");
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			};
			threadPoolExecutor.execute(myRunnable);

			Callable<String> myCallable = () -> {
				System.out.println("Inside myCallable. Going to sleep for 3 seconds..");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("myCallable is Done!");
				return "Hello from myCallable!";
			};
			Future<String> myCallableResult = threadPoolExecutor.submit(myCallable);

			System.out.println("Has myCallable finished:" + myCallableResult.isDone());
			System.out.println("myCallableResult=" + myCallableResult.get()); // wait until finished or interrupted

			// Executor is still runnig and waiting for tasks. Let's more runnables, submit, and shutdown
			MyCallable callable1 = new MyCallable(2);
			MyCallable callable2 = new MyCallable(3);
			MyCallable callable3 = new MyCallable(4);

			//List<Future<String>> results = threadPoolExecutor.invokeAll(Arrays.asList(callable1, callable2, callable3));
			String result = threadPoolExecutor.invokeAny(Arrays.asList(callable1, callable2, callable3));

			// Lets terminate the executor and wait for 3 secs to complete all 3 callables
			threadPoolExecutor.awaitTermination(3, TimeUnit.SECONDS);

			System.out.println("Result of InvokeAny()=" + result);
			// expecting AlreadyShutDown exception
			threadPoolExecutor.shutdown();
		} catch (InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
		}

	}

	private static class MyRunnable implements Runnable {
		private int runnableNum;

		public MyRunnable(final int runnableNum) {
			this.runnableNum = runnableNum;
		}

		public void run() {
			try {
				System.out.println(String.format("Inside MyRunnable[%s]. Going to sleep for 3 seconds..", runnableNum));
				TimeUnit.SECONDS.sleep(3);
				System.out.println(String.format("MyRunnable[%s] is Done!", runnableNum));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

	}

	private static class MyCallable implements Callable<String> {
		private int callableNum;

		public MyCallable(final int callableNum) {
			this.callableNum = callableNum;
		}

		@Override
		public String call() {
			try {
				System.out.println(String.format("Inside MyCallable[%s]. Going to sleep for 3 seconds..", callableNum));
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			return String.format("MyCallable[%s] is Done!", callableNum);
		}

	}

}
