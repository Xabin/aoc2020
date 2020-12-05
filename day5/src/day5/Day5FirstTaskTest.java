package day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day5FirstTaskTest {
	private Day5FirstTask testee;

	@Test
	public void exampleRow() {
		testee = new Day5FirstTask();

		assertEquals(44, testee.getRow("FBFBBFFRLR"));
	}

	@Test
	public void exampleColumn() {
		testee = new Day5FirstTask();

		assertEquals(5, testee.getColumn("FBFBBFFRLR"));
	}

	@Test
	public void exampleSeatId() {
		testee = new Day5FirstTask();

		assertEquals(357, testee.getSeatId("FBFBBFFRLR"));
	}

	@Test
	public void otherExample() {
		testee = new Day5FirstTask();

		assertEquals(567, testee.getSeatId("BFFFBBFRRR"));
		assertEquals(119, testee.getSeatId("FFFBBBFRRR"));
		assertEquals(820, testee.getSeatId("BBFFBBFRLL"));
	}
}
