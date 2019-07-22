package com.somnath.apps.algo;

import java.util.HashSet;
import java.util.Set;

public class Pangram {

	public static void main(String[] args) {

		char c1 = 'a', c2 = 'A'; // A=65
		char c3 = 'z', c4 = 'Z'; // Z=90
		char capitalized = (char) (c1 - 32);
		System.out.println("capitalized: " + capitalized);
		System.out.println((char)(c1-32));
		System.out.println((int)c1 + " " + (int)c2);
		System.out.println((int)c3 + " " + (int)c4);

		Set<Byte> alphabets = new HashSet<>(26);
		for(byte i=65; i<=90; i++) {
			alphabets.add(i);
		}

		//String str = "The quick brown fox jumps over the lazy dog".toUpperCase();
		String str = "The quick brown fox jumps over the lazy";
		//str.split()
		for(byte b : str.toUpperCase().getBytes()) {
			System.out.print(b);
			System.out.print(" ");
			alphabets.remove(b);
		}

		/*for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ')
				continue;
			else {
				alphabets.remove((int) c);
			}
		}*/

		System.out.println();
		System.out.print("Missing char to make pangram: ");
		alphabets.stream().map(i -> (char) i.intValue()).forEach(System.out::print);

	}
}
