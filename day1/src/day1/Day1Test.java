package day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day1Test {
	private Day1 testee = new Day1();

	@Test
	public void firstTaskVerifyExample() {
		List<String> exampleInput = Arrays.asList("1721", "979", "366", "299", "675", "1456");

		List<Integer> actual = testee.findSumTwoNumbers(exampleInput, 2020);

		assertEquals(2, actual.size());
		assertTrue(actual.contains(1721));
		assertTrue(actual.contains(299));
	}

	@Test
	public void secondTaskVerifyExample() {
		List<String> exampleInput = Arrays.asList("1721", "979", "366", "299", "675", "1456");

		List<Integer> actual = testee.findSumThreeNumbers(exampleInput, 2020);

		assertEquals(3, actual.size());
		assertTrue(actual.contains(979));
		assertTrue(actual.contains(366));
		assertTrue(actual.contains(675));
	}
}
