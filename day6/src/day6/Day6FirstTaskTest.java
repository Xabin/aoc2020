package day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day6FirstTaskTest {
	private Day6FirstTask testee;

	private final List<String> exampleInput = Arrays.asList("abc", //
			"", //
			"a", //
			"b", //
			"c", //
			"", //
			"ab", //
			"ac", //
			"", //
			"a", //
			"a", //
			"a", //
			"a", //
			"", //
			"b",
			"");

	@Test
	public void example() {
		testee = new Day6FirstTask();

		assertEquals(11, testee.countYes(exampleInput));
	}
}
