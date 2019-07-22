package com.somnath.apps.misc;

/* Nested classes:
	- static nested class
		-- .class pattern OuterClass$InnerClass.class
		-- can only access static members of the Outer class
		-- doesn't need an instance of outer class to instantiate

	- non static nested class (aka - inner class)
		-- can access both static and non-static members of the Outer class
		-- needs an instance of outer class to instantiate
		-- can be of three types:
			--- class level
			--- local: code block (if-else, switch-case etc.) + method local
				---- doesn't make sense to have access modifiers
				---- non access modifiers can be used: abstract, final, strictfp
		-- anonymous inner class
			--- implement interfaces as instance variable
			--- during method call - pass behavior as argument
		-- .class pattern OuterClass${Number}.InnerClass.class - Number (ex- 1) refers to a method
 */

class OuterClass {

	private static final String msg = "OuterClass Static Data.";
	private static final String anotherMsg = "OuterClass Non-Static Data.";

	// Static nested class
	public static class StaticNestedClass {

		// can ONLY acess static members of Outer class directly
		public void printMsg() {
			// Try making 'message' a non-static variable, there will be compile time  error
			System.out.println("Message from static nested class non-static method: " + msg);
		}

		public static void printMsgStatic() {
			System.out.println("Message from static nested class static method: " + msg);
		}
	}

	// non-static nested class - also called Inner Class
	public class InnerClass {
		// can access both static and non-static members of Outer class
		public void display(){
			System.out.println("Message from non-static nested class: " + msg);
			System.out.println("Another message from non-static nested class: " + anotherMsg);
		}

		// below results in compile time error - Inner classes cannot have static members and methods
		/*public static void displayStatic(){
			System.out.println("Message from non-static nested class: " + msg);
			System.out.println("Another message from non-static nested class: " + anotherMsg);
		}*/
	}

}

public class NestedClassTest {

	public static void main(String args[]) {

		// create instance of Static nested  class
		OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
		staticNested.printMsg(); // call non static methods
		OuterClass.StaticNestedClass.printMsgStatic(); // call static methods

		System.out.println();

		// In order to create instance of Inner class we need an Outer class instance.
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.display();

		// we can also combine above steps in one step to create instance of Inner class
		OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();
		inner2.display();
	}

}
