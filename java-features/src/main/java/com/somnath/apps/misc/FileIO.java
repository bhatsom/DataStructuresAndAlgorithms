package com.somnath.apps.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FileIO {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileIO.class);

	public static void main(String[] args) {

		LOGGER.info("Using File Writer and Reader...");
		String filePath = "/users/somnath/F/Practice/test-io-1.txt";

		try (
				PrintWriter writer = new PrintWriter(new FileWriter(filePath));
				BufferedReader br = new BufferedReader(new FileReader(filePath))
		) {

			Random generator = new Random();
			int noOfLines = generator.nextInt(10) + 1;
			LOGGER.info("Writing {} lines.", noOfLines);
			for (int i=1; i<=noOfLines; i++) {
				writer.append("Line # " + i);
				writer.println();
			}
			writer.flush();

			LOGGER.info("Now reading line by line..");
			String line;
			while ((line = br.readLine()) != null) {
				LOGGER.info("Line: {}", line);
			}

		} catch (IOException ex) {
			LOGGER.error("Error occurred:", ex);

		}
		LOGGER.info("DONE...");

		/*String test = "some text";
		Map<Character, Integer> countsMap = new HashMap<>();
		for (int i = 0; i <test.length(); i++) {
			Character c = test.charAt(i);
			countsMap.put(c, countsMap.putIfAbsent())
		}*/
	}


}
