package day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day11FirstTaskTest {
	private Day11FirstTask testee;

	private final List<String> exampleInput = Arrays.asList("LLLLLLLLLLLL", //
			"LL.LL.LL.LLL", //
			"LLLLLLLL.LLL", //
			"LL.L.L..L..L", //
			"LLLLL.LL.LLL", //
			"LL.LL.LL.LLL", //
			"LL.LLLLL.LLL", //
			"L..L.L.....L", //
			"LLLLLLLLLLLL", //
			"LL.LLLLLL.LL", //
			"LL.LLLLL.LLL", //
			"LLLLLLLLLLLL");

	@Test
	public void example() {
		testee = new Day11FirstTask();

		assertEquals(37, testee.findStableSeatCombinations(exampleInput));
	}
}
