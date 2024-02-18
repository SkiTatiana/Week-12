package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if(!expectException) {

			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);

		}
		else {


			assertThatThrownBy(() ->

			testDemo.addPositive(a, b))

			.isInstanceOf(IllegalArgumentException.class);
		}

	}

	static Stream<Arguments> argumentsForAddPositive () {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(0, -1, -2, true),
				arguments(2_000_000_000, 2_000_000_000, 0, true),
				arguments(1_000_000_000, 1_000_000, 1_001_000_000, false),
				arguments(0, 0, 0, true)

				);

	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {


		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);

		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);

		assertThat(testDemo.addPositive(1, 1_000_000)).isEqualTo(1_000_001);

		assertThat(testDemo.addPositive(1, 1_000_000_000)).isEqualTo(1_000_000_001);


	}

	@Test
	void assertThatMultiplyNumbersAreMultipliedCorrectly() {

		assertThat(testDemo.multiplyNumbers(4, 5)).isEqualTo(20);

		assertThat(testDemo.multiplyNumbers(1, 10)).isEqualTo(10);

		assertThat(testDemo.multiplyNumbers(0, 5)).isEqualTo(0);

		assertThat(testDemo.multiplyNumbers(10, 1_000_000)).isEqualTo(10_000_000);

	}

	@Test
	private void assertThatNumberSquaredIsCorrect() {

		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);

	}

}
