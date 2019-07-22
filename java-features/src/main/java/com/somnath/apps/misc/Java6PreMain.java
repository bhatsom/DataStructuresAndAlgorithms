package com.somnath.apps.misc;

import com.somnath.apps.java8.StreamExample1;

import java.util.ArrayList;
import java.util.List;

/*
Nested classes:
	- static nested class
		-- .class pattern OuterClass$InnerClass.class

	- non static nested class (aka - inner class)
		-- member/instance variable - class level
		-- local: code block(if-else, switch-case) + method local
			--- doesnt make sense to have access modifiers
			--- non access modifiers can be used: abstract, final, strictfp
		-- anonymous inner class
			-- implement interfaces as instance variable
			-- during method call - pass behavior as argument
		-- .class pattern OuterClass${Number}.InnerClass.class - Number (ex- 1) refers to a method
 */

public class Java6PreMain {

	public static void main(String[] args) {
		List<StreamExample1.LegalEnity> entities = new ArrayList<>();
		entities.add(new StreamExample1.LegalEnity(1, "Entity-1"));
		entities.add(new StreamExample1.LegalEnity(2, "Entity-2"));

		System.out.println("Entities: " + entities);
	}

}
