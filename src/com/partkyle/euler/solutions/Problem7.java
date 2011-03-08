package com.partkyle.euler.solutions;

import com.partkyle.euler.Euler;
import com.partkyle.euler.Solution;

public class Problem7 implements Solution {

	@Override
	public void solve() {
		int count = 1;
		long prime = 2;
		while (count < 10001) {
			prime++;
			while (!Euler.isPrime(prime)) {
				prime++;
			}
			count++;
		}
		System.out.println(Euler.isPrime(prime));
		System.out.println("Problem 7: " + prime);
	}

	public static void main(String[] args) {
		Solution solution = new Problem7();
		solution.solve();
	}

}
