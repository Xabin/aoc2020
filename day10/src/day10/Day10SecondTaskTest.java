package day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day10SecondTaskTest {
	private Day10SecondTask testee;

	private final List<String> exampleInput = Arrays.asList("16", //
			"10", //
			"15", //
			"5", //
			"1", //
			"11", //
			"7", //
			"19", //
			"6", //
			"12", //
			"4");

	private final List<String> longerExampleInput = Arrays.asList("28", //
			"33", //
			"18", //
			"42", //
			"31", //
			"14", //
			"46", //
			"20", //
			"48", //
			"47", //
			"24", //
			"23", //
			"49", //
			"45", //
			"19", //
			"38", //
			"39", //
			"11", //
			"1", //
			"32", //
			"25", //
			"35", //
			"8", //
			"17", //
			"7", //
			"9", //
			"4", //
			"2", //
			"34", //
			"10", //
			"3");

	@Test
	public void exampleOne() {
		testee = new Day10SecondTask();

		assertEquals(8, testee.findArrangements(exampleInput));
	}

	@Test
	public void exampleTwo() {
		testee = new Day10SecondTask();

		assertEquals(19208, testee.findArrangements(longerExampleInput));
	}

	// 0, 1, 4
	@Test
	public void oneAdapter() {
		testee = new Day10SecondTask();

		assertEquals(1, testee.findArrangements(Arrays.asList("1")));
	}

	// 0, 1, 2, 5
	// 0, 2, 5
	@Test
	public void twoAdapters() {
		testee = new Day10SecondTask();

		assertEquals(2, testee.findArrangements(Arrays.asList("1", "2")));
	}

	// 0, 1, 2, 3, 6
	// 0, 1, 3, 6
	// 0, 2, 3, 6
	// 0, 3, 6
	@Test
	public void threeAdapters() {
		testee = new Day10SecondTask();

		assertEquals(4, testee.findArrangements(Arrays.asList("1", "2", "3")));
	}
}
