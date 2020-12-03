package day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day3FirstTaskTest {
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

		assertEquals(7, testee.findTrees(3, 1));
	}

	@Test
	public void twoRows() {
		testee = new Day3FirstTask(Arrays.asList("..##.......", "..##......."));

		assertEquals(1, testee.findTrees(3, 1));
	}

	@Test
	public void twoRowsPastLength() {
		testee = new Day3FirstTask(Arrays.asList("....", "..#."));

		assertEquals(1, testee.findTrees(6, 1));
	}

	@Test
	public void canConvertToGrid() {
		testee = new Day3FirstTask(exampleInput);
		char[][] grid = testee.convertToGrid(exampleInput);

		assertEquals('.', grid[0][0]);
		assertEquals('.', grid[10][0]);
		assertEquals('.', grid[0][10]);
		assertEquals('#', grid[10][10]);
	}
}
