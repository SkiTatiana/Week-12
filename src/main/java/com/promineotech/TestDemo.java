package com.promineotech;

import java.util.Random;

public class TestDemo {



	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}

		if((long)a + (long)b > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Result exceeds integer limit!");
		} 

		return a+b;
	}

	public int multiplyNumbers(int a, int b) {
		return a * b;

	}
	
	public int getRandomInt() {

		Random random = new Random();

		return random.nextInt(10) + 1;

	}

	public int randomNumberSquared () {

		int num = getRandomInt();

		return num * num;
	}

}
