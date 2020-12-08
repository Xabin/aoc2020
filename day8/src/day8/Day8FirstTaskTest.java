package day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day8FirstTaskTest {
	private Day8FirstTask testee;

	private final List<String> exampleInput = Arrays.asList("nop +0", //
			"acc +1", //
			"jmp +4", //
			"acc +3", //
			"jmp -3", //
			"acc -99", //
			"acc +1", //
			"jmp -4", //
			"acc +6");

	@Test
	public void example() {
		testee = new Day8FirstTask();

		assertEquals(5, testee.findAccumulator(exampleInput));
	}
}
