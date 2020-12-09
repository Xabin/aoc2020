package day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day9FirstTaskTest {
	private Day9FirstTask testee;

	private final List<String> exampleInput = Arrays.asList("35", //
			"20", //
			"15", //
			"25", //
			"47", //
			"40", //
			"62", //
			"55", //
			"65", //
			"95", //
			"102", //
			"117", //
			"150", //
			"182", //
			"127", //
			"219", //
			"299", //
			"277", //
			"309", //
			"576");

	@Test
	public void example() {
		testee = new Day9FirstTask();

		assertEquals(127, testee.findFirstNoSum(exampleInput, 5));
	}
}
