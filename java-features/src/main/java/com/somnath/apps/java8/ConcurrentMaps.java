package com.somnath.apps.java8;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;

public class ConcurrentMaps {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Employee> map = new ConcurrentHashMap<>();

		System.out.println("START Populating 100 Employees: " + LocalDateTime.now());
		Random idGenerator = new Random();
		int randomNo;
		for (int i=1; i <=100; i++ ) {
			randomNo = idGenerator.nextInt(100) + 1;
			map.putIfAbsent(i, new Employee(randomNo, ("emp" + i), randomNo));
		}
		System.out.println("END Populating 100 Employees: " + LocalDateTime.now());
		usingForEach(map);
		usingPutIfAbsent(map);
		usingGetOrDefault(map);
	}

	private static void usingForEach(ConcurrentHashMap<Integer, Employee> map) {
		System.out.println("usingForEach START: " + LocalDateTime.now());

		//forEach uses ForkJoinPool under the hood
		System.out.println("ForkJoinPool parallelism: " + ForkJoinPool.getCommonPoolParallelism());

		map.forEach(10, (k, v) ->
			System.out.printf("Thread=%s Emp Info: id=%d name=%s sal=%d \n",
					Thread.currentThread().getName(), k, v.name, v.salary)
		);
		System.out.println("usingForEach END: " + LocalDateTime.now());
	}

	public static void usingPutIfAbsent(ConcurrentHashMap<Integer, Employee> map) {
		System.out.println("Put id 100:" + map.putIfAbsent(100, new Employee(100,"emp100", 1001)));
		System.out.println("Put id 101:" + map.putIfAbsent(101, new Employee(101,"emp101", 20000)));
	}

	public static void usingGetOrDefault(ConcurrentHashMap<Integer, Employee> map) {
		System.out.println("Get id 101:" + map.getOrDefault(101, null));
		System.out.println("Get id 102:" + map.getOrDefault(102, new Employee(102,"emp102", 102)));
	}

	private static final class Employee {
		private int id;
		private String name;
		private int salary;

		public Employee(int id, String name, int salary) {
			this.id = id;
			this.name = name;
			this.salary = salary;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getSalary() {
			return salary;
		}

		@Override
		public String toString() {
			return "[" + Objects.toString(id) + ":" + Objects.toString(name) + ":" + Objects.toString(salary) + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, name, salary);
		}

	}


}
