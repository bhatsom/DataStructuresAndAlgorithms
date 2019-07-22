package com.somnath.apps.java8;

import java.util.Objects;
import java.util.Optional;

public class OptionalUsageInImmutability {

	public static void main(String[] args) {
		System.out.println("start...");

		ImmutableDog dog1 = new ImmutableDog("Dog1", Optional.of(10)); //OK
		System.out.println("dog1 created: name=" + dog1.getName() + " weight=" + dog1.getWeight().orElse(0));

		ImmutableDog dog2 = new ImmutableDog("Dog2", null); //OK
		System.out.println("dog2 created: name=" + dog2.getName() + " weight=" + dog2.getWeight().orElse(0));

		ImmutableDog dog3 = new ImmutableDog(null, null); //ERROR
		System.out.println("dog3 created: name=" + dog3.getName() + " weight=" + dog3.getWeight());

		System.out.println("end...");
	}

	private static class ImmutableDog {
		private final String name;
		private final Optional<Integer> weight;

		public ImmutableDog(String name, Optional<Integer> weight){
			Objects.requireNonNull(name);
			this.name = name;
			this.weight = weight;
		}

		public String getName(){
			return this.name;
		}

		public Optional<Integer> getWeight(){
			return this.weight;
		}
	}

}
