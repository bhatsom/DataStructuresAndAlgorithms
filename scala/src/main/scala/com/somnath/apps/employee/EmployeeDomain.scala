package com.somnath.apps.employee


object StateCode extends Enumeration {
  //type StateCode
  val NC, NY, TX = Value
}

case class Address(
                  street: String,
                  city: String,
                  stateCode: StateCode.Value,
                  zipCode: Int)

case class Employee(
                   id: Int,
                   name: String,
                   address: Address,
                   salrary: Int
                   )


