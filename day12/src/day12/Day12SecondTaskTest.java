package day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day12SecondTaskTest {
	private Day12SecondTask testee;

	private final List<String> exampleInput = Arrays.asList("F10", //
			"N3", //
			"F7", //
			"R90", //
			"F11");

	@Test
	public void example() {
		testee = new Day12SecondTask();

		assertEquals(286, testee.calculateManhattanDistance(exampleInput));
	}
	
	@Test
	public void canTurn() {
		testee = new Day12SecondTask();
		testee.moveWaypoint(Action.NORTH, 3);
		
		testee.turnWaypoint(Action.RIGHT, 90);
		
		assertEquals(4, testee.waypointEast);
		assertEquals(-10, testee.waypointNorth);
	}
}
