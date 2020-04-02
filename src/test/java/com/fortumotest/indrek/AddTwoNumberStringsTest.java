package com.fortumotest.indrek;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AddTwoNumberStringsTest {

	@Test
	void testNumberAddition() {
		int a = 4;
		int b = 1;

		String expected = Integer.toString(a + b);

		AddTwoNumberStrings adder = new AddTwoNumberStrings(Integer.toString(a), Integer.toString(b));
		String result = adder.sum();

		Assert.assertEquals(expected, result);
	}

	@Test
	void testNumberAdditionFailure() {
		int a = 4;
		int b = 1;

		String expected = "2345654565456";

		AddTwoNumberStrings adder = new AddTwoNumberStrings(Integer.toString(a), Integer.toString(b));
		String result = adder.sum();

		Assert.assertNotEquals(expected, result);
	}

}