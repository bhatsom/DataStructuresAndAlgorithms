package com.somnath.apps.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "emp 1", 0x50000));
		employees.add(new Employee(2, "emp 2", 060000));
		employees.add(new Employee(3, "emp 3", 70000));

		System.out.println("Employee 1: " + employees.get(0));
		System.out.println("Employee 2: " + employees.get(1));
		System.out.println("Employee 3: " + employees.get(2));
		List<String> allNames = employees.stream()
				.flatMap(e -> Stream.of(
						e.id + e.getName()))
				.collect(Collectors.toList());
		System.out.println("All names: " + allNames);
	}

	public static final class Employee {
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

	public static final class LegalEnity {
		private int entityId;
		private String entityName;

		public LegalEnity(int entityId, String entityName) {
			this.entityId = entityId;
			this.entityName = entityName;
		}

		public int getEntityId() {
			return entityId;
		}

		public String getEntityName() {
			return entityName;
		}

		@Override
		public String toString() {
			return "[" + Objects.toString(entityId) + ":" + Objects.toString(entityName) + "]";
		}
	}

}
