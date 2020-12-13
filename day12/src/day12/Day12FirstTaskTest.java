package day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day12FirstTaskTest {
	private Day12FirstTask testee;

	private final List<String> exampleInput = Arrays.asList("F10", //
			"N3", //
			"F7", //
			"R90", //
			"F11");

	@Test
	public void example() {
		testee = new Day12FirstTask();

		assertEquals(25, testee.calculateManhattanDistance(exampleInput));
	}
	
	@Test
	public void canTurn() {
		assertEquals(Action.EAST, Action.turn(Action.NORTH, Action.RIGHT, 1));
		assertEquals(Action.SOUTH, Action.turn(Action.NORTH, Action.RIGHT, 2));
		assertEquals(Action.WEST, Action.turn(Action.NORTH, Action.RIGHT, 3));
		assertEquals(Action.NORTH, Action.turn(Action.NORTH, Action.RIGHT, 4));
		assertEquals(Action.WEST, Action.turn(Action.NORTH, Action.LEFT, 1));
		assertEquals(Action.SOUTH, Action.turn(Action.NORTH, Action.LEFT, 2));
		assertEquals(Action.EAST, Action.turn(Action.NORTH, Action.LEFT, 3));
		assertEquals(Action.NORTH, Action.turn(Action.NORTH, Action.LEFT, 4));
	}
}
