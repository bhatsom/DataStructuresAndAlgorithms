package com.somnath.apps.collection

import scala.collection.mutable.{Map => MutableMap, Set => MutableSet}

object Collections extends App {

  println("*************** Array Start ***************")
  //Array - is mutable collection

  //most verbose
  val names: Array[String] = new Array[String](2)
  names(0) = "FN1 LN1"
  names.update(1, "FN2 LN2")

  print("names:")
  for (i <- 0 until names.length)
    print(names(i) + "\t")

  //less verbose
  val names2 = new Array[String](2)
  names2(0) = "FN1 LN1"
  names2.update(1, "FN2 LN2")

  print("name2:")
  for (i <- 0 until names.length)
    print(names2(i) + "\t")

  //least verbose
  val names3 = Array("FN1 LN1", "FN2 LN2")
  //val names3 = Array.apply("FN1 LN1", "FN2 LN2")

  print("name3:")
  for (name <- names3)
    print(name + "\t")
  println("*************** Array End ***************")

  println("*************** List Start ***************")
  //List - is immutable by default

  val numbers = List(1, 2, 3, 4, 5)
  println(s"TOTAL: ${numbers.reduce((e1, e2) => e1 + e2)}")
  println(s"DOUBLED: ${numbers.map(e => e * 2)}")

  println("*************** List End ***************")

  println("*************** Map Start ***************")
  //Map - can be both mutable and immutable

  // not so good way - without using tuple
  var dataMap1 = Map((1, 'X'), (2, 'Y'))
  dataMap1 += ((3, 'Z'))
  println(s"dataMap1: $dataMap1")

  //better - more readable way of declaring map
  var dataMap2 = Map(1 -> 'X', 2 -> 'Y')
  dataMap2 += (3 -> 'Z', 4 -> 'A')
  println(s"dataMap2: $dataMap2")

  //mutable map
  val dataMap3 = MutableMap[Int, String]()
  dataMap3(1) = "X"
  dataMap3.update(2 , "Y")
  dataMap3 += (3 -> "Z")
  println(s"dataMap3: $dataMap3")

  println("*************** Map End ***************")

  println("DONE...")
}
