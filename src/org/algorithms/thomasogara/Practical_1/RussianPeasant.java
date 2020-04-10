package org.algorithms.thomasogara.Practical_1;

public class RussianPeasant{
	public static long russianPeasantAlgorithm(long a, long b) throws Exception {
		// long variable to store result of multiplication
		long result = 0;
		// the actual russian peasant algorithm
		// for so long as b has not been reduced to 0,
		// add a to the sum, if and only if b is odd
		while(b > 0){
			if((b % 2) == 1){
				result += a;
			}
			b /= 2;
			a *= 2;
		}
		return result;
	}

}
