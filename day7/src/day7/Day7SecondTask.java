package day7;

import java.util.List;

public class Day7SecondTask {
	public Bag filterRule(List<Bag> rules, String type) {
		for (Bag rule : rules) {
			if (rule.getType().equals(type)) {
				return rule;
			}
		}

		return null;
	}

	public int countBagsInside(Bag bag) {
		int innerBagCount = 0;
		
		for (Bag innerBag : bag.getBags().values()) {
			innerBagCount += innerBag.getAmount() + countBagsInside(innerBag);
		}
		
		if (bag.getType().equals("shiny gold")) {
			return innerBagCount;
		}
		
		return bag.getAmount() * innerBagCount;
	}
}
