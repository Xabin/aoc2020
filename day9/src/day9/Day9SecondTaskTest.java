package day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day9SecondTaskTest {
	private Day9SecondTask testee;

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
		testee = new Day9SecondTask();

		assertEquals(62, testee.findEncryptionWeakness(exampleInput, 5));
	}
}
