package com.somnath.apps.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEquals {

	public static void main(String[] args) {

		Map<Employee, String> empMap = new HashMap<>();

		empMap.put(new Employee(101, "Emp1"), "Emp1");
		empMap.put(new Employee(102, "Emp2"), "Emp2");
		empMap.put(new Employee(103, "Emp3"), "Emp3");
		empMap.put(new Employee(101, "Emp1"), "Emp4"); // duplicate key but different value

		for (Map.Entry<Employee, String> empEntry : empMap.entrySet()) {
			Employee key = empEntry.getKey();
			System.out.println(String.format("[Key:Id=%s name=%s] -> [Val=%s]", key.getEmpId(), key.getEmpName(), empEntry.getValue()));
		}

		/* Prints below. No duplicate entries exist - key is replaced
		[Key:Id=101 name=Emp1] -> [Val=Emp4]
		[Key:Id=102 name=Emp2] -> [Val=Emp2]
		[Key:Id=103 name=Emp3] -> [Val=Emp3]
		*/

		// returns proper value for all keys
		System.out.println("Emp 101=" + empMap.get(new Employee(101, "Emp1")));
		System.out.println("Emp 102=" + empMap.get(new Employee(102, "Emp2")));
		System.out.println("Emp 103=" + empMap.get(new Employee(103, "Emp3")));
	}

	private static class Employee {
		private int empId;
		private String empName;

		public Employee(int empId, String empName) {
			this.empId = empId;
			this.empName = empName;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		@Override
		public int hashCode() {
			return Objects.hash(empId, empName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Employee employee = (Employee) o;
			return empId == employee.empId &&
					Objects.equals(empName, employee.empName);
		}
	}

}


