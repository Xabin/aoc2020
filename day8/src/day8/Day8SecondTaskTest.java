package day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day8SecondTaskTest {
	private Day8SecondTask testee;

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
		testee = new Day8SecondTask();

		assertEquals(8, testee.findAccumulator(exampleInput));
	}
}
