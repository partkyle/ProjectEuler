package com.partkyle.euler.solutions;

import java.util.Set;
import java.util.TreeSet;

import com.partkyle.euler.Solution;

public class Problem4 implements Solution {

	@Override
	public void solve() {
		Set<Long> palindromes = new TreeSet<Long>();
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				long result = i * j;
				if (isPalidrome(result)) {
					palindromes.add(result);
				}
			}
		}

		System.out.println("Problem 4: "
				+ palindromes.toArray()[palindromes.size() - 1]);
	}

	public boolean isPalidrome(long n) {
		String forwards = String.valueOf(n);
		String backwards = new StringBuffer(forwards).reverse().toString();
		return forwards.equals(backwards);
	}

	public static void main(String[] args) {
		Solution solution = new Problem4();
		solution.solve();
	}

}
