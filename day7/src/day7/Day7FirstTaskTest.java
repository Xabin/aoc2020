package day7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Day7FirstTaskTest {
	private Day7FirstTask testee;

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

	private final List<String> extendedEampleInput = Arrays.asList(
			"light red bags contain 1 bright white bag, 2 muted yellow bags, 2 shiny gold bags, 1 faded blue bag.", //
			"dark orange bags contain 3 bright white bags, 4 muted yellow bags.", //
			"bright white bags contain 1 shiny gold bag.", //
			"muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.", //
			"shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.", //
			"dark olive bags contain 3 faded blue bags, 4 dotted black bags.", //
			"vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.", //
			"faded blue bags contain no other bags.", //
			"dotted black bags contain no other bags.");

	private final List<String> shortInput = Arrays.asList(
			"light red bags contain 1 bright white bag, 2 dark orange bags.", //
			"dark orange bags contain 3 faded blue bags, 4 dotted black bags.", //
			"bright white bags contain 1 dotted black bag.", //
			"faded blue bags contain no other bags.", //
			"dotted black bags contain no other bags.");

	@Test
	public void example() {
		testee = new Day7FirstTask();
		testee.createInitialRules(exampleInput);
		testee.createFullRules();

		assertEquals(4, testee.howManyBagsCanCarry("shiny gold"));
	}

	@Test
	public void otherExample() {
		testee = new Day7FirstTask();
		testee.createInitialRules(extendedEampleInput);
		testee.createFullRules();

		assertEquals(4, testee.howManyBagsCanCarry("shiny gold"));
	}

	@Test
	public void canCreateInitialRules() {
		testee = new Day7FirstTask();

		Map<String, List<Bag>> initialRules = testee.createInitialRules(exampleInput);
		
		assertEquals(9, initialRules.size());
		assertTrue(!initialRules.get("light red").isEmpty());
		assertTrue(initialRules.get("dotted black").isEmpty());
	}

	@Test
	public void testShortInput() {
		testee = new Day7FirstTask();

		testee.createInitialRules(shortInput);
		
		List<Bag> bags = testee.createFullRules();
		
		Bag redLight = bags.get(0);
		assertEquals("light red", redLight.getType());
		
		Map<String, Bag> redLightBags = redLight.getBags();
		assertEquals(2, redLightBags.size());
		assertTrue(redLightBags.containsKey("bright white"));
		assertTrue(redLightBags.containsKey("dark orange"));
		
		Bag brightWhiteBag = redLightBags.get("bright white");
		assertEquals("bright white", brightWhiteBag.getType());
		
		Map<String, Bag> brightWhiteBags = brightWhiteBag.getBags();
		assertEquals(1, brightWhiteBags.size());
		assertTrue(brightWhiteBags.containsKey("dotted black"));
		
		Bag dottedBlackBag = brightWhiteBags.get("dotted black");
		assertEquals("dotted black", dottedBlackBag.getType());
		
		Map<String, Bag> dottedBlackBags = dottedBlackBag.getBags();
		assertTrue(dottedBlackBags.isEmpty());
	}
}
