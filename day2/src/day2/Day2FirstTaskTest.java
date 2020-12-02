package day2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Day2FirstTaskTest {
	private Day2FirstTask testee = new Day2FirstTask();

	@Test
	public void exampleOneValidPassword() {
		int exampleMin = 1;
		int exampleMax = 3;
		char exampleChar = 'a';
		String examplePassword = "abcde";

		boolean valid = testee.passwordValid(exampleMin, exampleMax, exampleChar, examplePassword);

		assertTrue(valid);
	}

	@Test
	public void exampleTwoInvalidPassword() {
		int exampleMin = 1;
		int exampleMax = 3;
		char exampleChar = 'b';
		String examplePassword = "cdefg";

		boolean valid = testee.passwordValid(exampleMin, exampleMax, exampleChar, examplePassword);

		assertFalse(valid);
	}

	@Test
	public void exampleThreeValidPassword() {
		int exampleMin = 2;
		int exampleMax = 9;
		char exampleChar = 'c';
		String examplePassword = "ccccccccc";

		boolean valid = testee.passwordValid(exampleMin, exampleMax, exampleChar, examplePassword);

		assertTrue(valid);
	}
}
