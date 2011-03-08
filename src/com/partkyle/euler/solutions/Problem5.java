package com.partkyle.euler.solutions;

import com.partkyle.euler.Solution;

public class Problem5 implements Solution {

	@Override
	public void solve() {
		long i = 2520;
		long result = -1;
		while (result < 0) {
			if (div20(i)) {
				result = i;
			}
			i++;
		}
		System.out.println("Problem 5: " + result);
	}

	public boolean div20(long n) {
		for (int i = 1; i <= 20; i++) {
			if (n % i != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Problem5();
		solution.solve();
	}

}
