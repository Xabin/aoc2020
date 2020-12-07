package day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day7SecondTaskTest {
	private Day7SecondTask testee;

	private final List<String> exampleInput = Arrays.asList(
			"light red bags contain 1 bright white bag, 2 muted yellow bags.", //
			"dark orange bags contain 3 bright white bags, 4 muted yellow bags.", //
			"bright white bags contain 1 shiny gold bag.", //
			"muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.", //
			"shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.", //
			"dark olive bags contain 3 faded blue bags, 4 dotted black bags.", //
			"vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.", //
			"faded blue bags contain no other bags.", //
			"dotted black bags contain no other bags.");

	private final List<String> exampleInput2 = Arrays.asList("shiny gold bags contain 2 dark red bags.", //
			"dark red bags contain 2 dark orange bags.", //
			"dark orange bags contain 2 dark yellow bags.", //
			"dark yellow bags contain 2 dark green bags.", //
			"dark green bags contain 2 dark blue bags.", //
			"dark blue bags contain 2 dark violet bags.", //
			"dark violet bags contain no other bags.");

	@Test
	public void example() {
		testee = new Day7SecondTask();
		Day7FirstTask firstTask = new Day7FirstTask();
		firstTask.createInitialRules(exampleInput);
		List<Bag> fullRules = firstTask.createFullRules();
		Bag shinyGoldBag = testee.filterRule(fullRules, "shiny gold");

		assertEquals(32, testee.countBagsInside(shinyGoldBag));
	}

	@Test
	public void example2() {
		testee = new Day7SecondTask();
		Day7FirstTask firstTask = new Day7FirstTask();
		firstTask.createInitialRules(exampleInput2);
		List<Bag> fullRules = firstTask.createFullRules();
		Bag shinyGoldBag = testee.filterRule(fullRules, "shiny gold");

		assertEquals(126, testee.countBagsInside(shinyGoldBag));
	}

	@Test
	public void canFilterRule() {
		testee = new Day7SecondTask();
		Day7FirstTask firstTask = new Day7FirstTask();
		firstTask.createInitialRules(exampleInput);
		List<Bag> fullRules = firstTask.createFullRules();

		Bag bag = testee.filterRule(fullRules, "shiny gold");

		assertEquals("shiny gold", bag.getType());
	}
}
