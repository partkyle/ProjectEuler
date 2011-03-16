package com.partkyle.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ServiceLoader;


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

	private static Solution getProblem(String number) {
		ServiceLoader<Solution> problems = ServiceLoader.load(Solution.class);
		for (Solution solution : problems) {
			if (solution.getClass().getSimpleName().equals("Problem" + number))
				return solution;
		}
		throw new RuntimeException("Could not load Problem" + number);
	}

	public static void main(String[] args) {

		String action = getProblemNumber();

		while (!"exit".equalsIgnoreCase(action)) {
			try {
				getProblem(action).solve();
			} catch (Exception e) {
				System.out.println(String.format(
						"Problem implementation %s missing.", action));
			}
			action = getProblemNumber();

		}
	}
}
