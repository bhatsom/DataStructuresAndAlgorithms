package com.somnath.apps.java8;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.time.*;

public class StreamExample2 {

	public static void main(String[] args) {

		System.out.println("No of Processors: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Total Memory (MB): " + Runtime.getRuntime().totalMemory()/(1024 * 1024));
		System.out.println("Free Memory (MB): " + Runtime.getRuntime().freeMemory()/(1024 * 1024));
		// test performance of stream vs parallel stream
		List<StreamExample1.Employee> employees = new ArrayList<>();

		System.out.println("START Populating 100K Employees: " + LocalDateTime.now());
		//https://www.geneseo.edu/~baldwin/reference/random.html
		Random idGenerator = new Random();
		int randomNo;
		for (int i=0; i <50_000_000; i++ ) {
			randomNo = idGenerator.nextInt(100_000) + 1;
			employees.add(new StreamExample1.Employee(randomNo,"emp1", randomNo));
		}
		System.out.println("END Populating 100K Employees: " + LocalDateTime.now());

		System.out.println("Total Memory (MB): " + Runtime.getRuntime().totalMemory()/(1024 * 1024));
		System.out.println("Free Memory (MB): " + Runtime.getRuntime().freeMemory()/(1024 * 1024));

		usingSerialStream(employees);  // 21 sec for 50m records
		usingParallelStream(employees); //13 sec for 50m records
		usingForkAndJoin(employees);
	}

	private static void usingSerialStream(List<StreamExample1.Employee> empList) {
		System.out.println("Serial START: " + LocalDateTime.now());

		List<StreamExample1.Employee> filteredSorteList = empList.stream()
				.filter(e -> e.getSalary() > 50_000)
				.sorted((e1, e2) -> e1.getId() - e2.getId())
				//could be simply below
				//.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());

		System.out.println("filteredSorteList size: " + filteredSorteList.size());
		System.out.println("Serial END: " + LocalDateTime.now());

	}

	private static void usingParallelStream(List<StreamExample1.Employee> empList) {
		System.out.println("Parallel START: " + LocalDateTime.now());

		List<StreamExample1.Employee> filteredSorteList = empList.parallelStream()
				.filter(e -> e.getSalary() > 50_000)
				.sorted(Comparator.comparing(StreamExample1.Employee::getName))
				.collect(Collectors.toList());
		System.out.println("filteredSorteList size: " + filteredSorteList.size());
		System.out.println("Parallel END: " + LocalDateTime.now());

	}

	/**
	 * This method tests performance of ForkJoinPool framework - introduced in Java 7.
	 * @param empList
	 */
	private static void usingForkAndJoin(List<StreamExample1.Employee> empList) {
		System.out.println("ForkJoin START: " + LocalDateTime.now());
		List<StreamExample1.Employee> finalSortedList = new ArrayList<>();

		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		//ForkJoinPool is an implementation fo ExecutorService

		/*
		ForkJoinTask does the computation. Two implementations exists out of the box: RecursiveAction and RecursiveTask.
		RecursiveAction - doesn't return value
		RecursiveTask returns an object of specified type
		*/

		RecursiveAction computer = new RecursiveAction() {
			@Override
			protected void compute() {
				for (StreamExample1.Employee e : empList) {
					if (e.getSalary() > 50_000)
						finalSortedList.add(e);

				}
				Collections.sort(finalSortedList, Comparator.comparing(StreamExample1.Employee::getName));
			}
		};

		pool.invoke(computer);
		System.out.println("filteredSorteList size: " + finalSortedList.size());
		System.out.println("ForkJoin END: " + LocalDateTime.now());

	}

	/*

No of Processors: 8
Total Memory (MB): 245
Free Memory (MB): 240
START Populating 100K Employees: 2017-12-24T23:03:16.439
END Populating 100K Employees: 2017-12-24T23:03:38.928
Free Memory (MB): 975
Serial START: 2017-12-24T23:03:38.929
filteredSorteList size: 24_999_493
Serial END: 2017-12-24T23:03:59.295

No of Processors: 8
Total Memory (MB): 245
Free Memory (MB): 239
START Populating 100K Employees: 2017-12-24T23:05:58.880
END Populating 100K Employees: 2017-12-24T23:06:20.761
Free Memory (MB): 985
Parallel START: 2017-12-24T23:06:20.761
filteredSorteList size: 25_003_707
Parallel END: 2017-12-24T23:06:29.271

No of Processors: 8
Total Memory (MB): 245
Free Memory (MB): 240
START Populating 100K Employees: 2017-12-24T23:24:23.327
END Populating 100K Employees: 2017-12-24T23:24:46.037
Free Memory (MB): 981
ForkJoin START: 2017-12-24T23:24:46.037
filteredSorteList size: 24_999_105
ForkJoin END: 2017-12-24T23:24:48.289

=======RAN ALL TOGETHER=============
No of Processors: 8
Total Memory (MB): 245
Free Memory (MB): 240
START Populating 100K Employees: 2017-12-24T23:28:44.827
END Populating 100K Employees: 2017-12-24T23:29:04.780
Total Memory (MB): 2097
Free Memory (MB): 502

Serial START: 2017-12-24T23:29:04.780
filteredSorteList size: 24999288
Serial END: 2017-12-24T23:29:28.169

Parallel START: 2017-12-24T23:29:28.169
filteredSorteList size: 24999288
Parallel END: 2017-12-24T23:29:33.746

ForkJoin START: 2017-12-24T23:29:33.746
filteredSorteList size: 24999288
ForkJoin END: 2017-12-24T23:29:34.922

ForkJoin always wins: 21,  9, 2 sec respectively
	 */

}
