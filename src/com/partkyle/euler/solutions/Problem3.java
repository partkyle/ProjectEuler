package com.partkyle.euler.solutions;

import java.util.Collection;

import com.partkyle.euler.Euler;
import com.partkyle.euler.Solution;
import com.partkyle.util.Filter;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */

public class Problem3 implements Solution {

	@Override
	public void solve() {
		Collection<Long> factors = Euler.factors(600851475143l);

		System.out.println("Factors of 600851475143:");
		System.out.println(factors);

		factors = new Filter<Long>() {
			@Override
			public boolean predicate(Long item) {
				return Euler.isPrime(item);
			}
		}.filter(factors);

		System.out.println("Prime factors of 600851475143:");
		System.out.println(factors);

		System.out.println("Problem 3: "
				+ factors.toArray()[factors.size() - 1]);
	}

	public static void main(String[] args) {
		Solution solution = new Problem3();
		solution.solve();
	}
}
