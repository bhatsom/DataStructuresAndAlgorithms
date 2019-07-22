package com.somnath.apps.employee

import scala.collection.mutable.{Map => MutableMap}

object EmployeeSalStats {

  def main(args: Array[String]): Unit = {
    println("Running Employee Stats...")
    val employees = MutableMap[Int, Employee]()

    employees += (101 -> new Employee(101, "John Doe", new Address("101 Main St", "Raleigh", StateCode.NC, 27560), 200))
    employees(102) = new Employee(102, "Peter Hood", new Address("500 2nd St", "Cary", StateCode.NC, 27511), 300)
    employees += (103 -> new Employee(103, "Calie Sams", new Address("456 47th St", "Raleigh", StateCode.NC, 27560), 150))
    println(s"Here is my employee List\n: ${employees}")

    employees.foreach(e => println(e))

    println(s"employee with id=101:\n${employees.get(101)}")
    println(s"employee with id=102:\n${employees.getOrElse(102, None)}")
    println(s"employee with id=103:\n${employees.get(103).get}")
  }

}
