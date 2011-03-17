package com.partkyle.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ServiceLoader;

public class ProblemRunner {

	private String getProblemNumber() {
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

	private Solution getProblem(String number) {
		changeServices(number);
		ServiceLoader<Solution> problems = ServiceLoader.load(Solution.class);
		for (Solution solution : problems) {
			if (solution.getClass().getSimpleName().equals("Problem" + number))
				return solution;
		}
		throw new RuntimeException("Could not load Problem" + number);
	}

	private void changeServices(String number) {
		String problem = "com.partkyle.euler.solutions.Problem" + number;

		try {
			Class.forName(problem);

			FileOutputStream os = new FileOutputStream(
					"bin/META-INF/services/com.partkyle.euler.Solution");
			os.write(problem.getBytes("UTF-8"));

			System.gc();
			System.gc();
			System.gc();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ProblemRunner runner = new ProblemRunner();

		String action = runner.getProblemNumber();

		while (!"exit".equalsIgnoreCase(action)) {
			try {
				runner.getProblem(action).solve();
			} catch (Exception e) {
				System.out.println(String.format(
						"Problem implementation %s missing.", action));
			}
			action = runner.getProblemNumber();

		}
	}
}
