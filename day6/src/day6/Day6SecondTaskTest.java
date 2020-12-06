package day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day6SecondTaskTest {
	private Day6SecondTask testee;

	private List<String> exampleInput = Arrays.asList("abc", //
			"", //
			"a", //
			"b", //
			"c", //
			"", //
			"ab", //
			"ac", //
			"", //
			"a", //
			"a", //
			"a", //
			"a", //
			"", //
			"b", //
			"");

	@Test
	public void example() {
		testee = new Day6SecondTask();

		assertEquals(6, testee.countYes(exampleInput));
	}

	@Test
	public void canCreateGroups() {
		testee = new Day6SecondTask();

		assertEquals(5, testee.createGroups(exampleInput).size());
	}

	@Test
	public void firstGroupContainsOnePerson() {
		testee = new Day6SecondTask();

		assertEquals(1, testee.createGroups(exampleInput).get(0).getPersons().size());
	}

	@Test
	public void secondGroupContainsThreePersons() {
		testee = new Day6SecondTask();

		assertEquals(3, testee.createGroups(exampleInput).get(1).getPersons().size());
	}
}
