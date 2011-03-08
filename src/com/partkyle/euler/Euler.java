package com.partkyle.euler;

import java.util.Set;
import java.util.TreeSet;

public class Euler {
	public static boolean isPrime(long n) {
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static Set<Long> factors(long n) {
		Set<Long> factors = new TreeSet<Long>();
		factors.add(1l);
		factors.add(n);

		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				factors.add(i);
			}
		}

		return factors;
	}
}
