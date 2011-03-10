package com.partkyle.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemRunner {

	private static String getProblemNumber() {
		System.out.print("Problem #?: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String number = null;

		try {
			number = br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			System.exit(1);
		}

		return number;
	}

	public static void main(String[] args) {
		String action = getProblemNumber();

		while (!"exit".equalsIgnoreCase(action)) {
			try {
				Solution solution = (Solution) Class.forName(
						"com.partkyle.euler.solutions.Problem" + action)
						.newInstance();
				solution.solve();
			} catch (Exception e) {
				System.out.println(String.format("Problem implementation %s missing.",
						action));
			}
			action = getProblemNumber();

		}
	}
}
