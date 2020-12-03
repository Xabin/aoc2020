package day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day3SecondTaskTest {
	private Day3FirstTask testee;

	private List<String> exampleInput = Arrays.asList("..##.......", //
			"#...#...#..", //
			".#....#..#.", //
			"..#.#...#.#", //
			".#...##..#.", //
			"..#.##.....", //
			".#.#.#....#", //
			".#........#", //
			"#.##...#...", //
			"#...##....#", //
			".#..#...#.#");

	@Test
	public void example() {
		testee = new Day3FirstTask(exampleInput);

		assertEquals(2, testee.findTrees(1, 1));
		assertEquals(7, testee.findTrees(3, 1));
		assertEquals(3, testee.findTrees(5, 1));
		assertEquals(4, testee.findTrees(7, 1));
		assertEquals(2, testee.findTrees(1, 2));
	}

}
