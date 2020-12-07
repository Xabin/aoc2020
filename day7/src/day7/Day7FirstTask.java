package day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7FirstTask {
	private Map<String, List<Bag>> initialRules;
	private List<Bag> fullRules;

	public int howManyBagsCanCarry(String type) {
		int canCarry = 0;

		for (Bag rule : fullRules) {
			if (rule.toString().contains("shiny gold")) {
				canCarry++;
			}
		}

		return canCarry - 1;
	}

	public Bag createRules(String rule) {
		String type = rule.substring(0, rule.indexOf(" bags"));

		if (rule.contains("contain no other bags")) {
			return new Bag(type, 0, Collections.emptyMap());
		}

		String contents = rule.substring(rule.indexOf("contain ") + 8, rule.length() - 1);
		String[] containedBagsString = contents.split(", ");
		Map<String, Bag> containedBags = new HashMap<>();

		for (String containedBag : containedBagsString) {
			int containedBagAmount = Integer.valueOf(containedBag.substring(0, 1));
			String containedBagType = containedBag.substring(2, containedBag.indexOf(" bag"));
			containedBags.put(containedBagType, new Bag(containedBagType, containedBagAmount, Collections.emptyMap()));
		}

		return new Bag(type, 0, containedBags);
	}

	public Map<String, List<Bag>> createInitialRules(List<String> rules) {
		initialRules = new HashMap<>();

		for (String rule : rules) {
			String type = rule.substring(0, rule.indexOf(" bags"));

			if (rule.contains("contain no other bags")) {
				initialRules.put(type, Collections.emptyList());
				continue;
			}

			String contents = rule.substring(rule.indexOf("contain ") + 8, rule.length() - 1);
			String[] containedBagsString = contents.split(", ");
			List<Bag> bags = new ArrayList<>();

			for (String containedBag : containedBagsString) {
				bags.add(new Bag(containedBag.substring(2, containedBag.indexOf(" bag")),
						Integer.valueOf(containedBag.substring(0, 1)), Collections.emptyMap()));
			}

			initialRules.put(type, bags);
		}

		return initialRules;
	}

	public List<Bag> createFullRules() {
		fullRules = new ArrayList<>();

		for (String type : initialRules.keySet()) {
			List<Bag> bags = initialRules.get(type);
			if (bags.isEmpty()) {
				continue;
			}

			fullRules.add(new Bag(type, bags.size(), findBags(type)));
		}

		return fullRules;
	}

	private Map<String, Bag> findBags(String type) {
		List<Bag> initialRule = initialRules.get(type);

		if (initialRule.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<String, Bag> bags = new HashMap<>();

		for (Bag subBag : initialRule) {
			bags.put(subBag.getType(), new Bag(subBag.getType(), subBag.getAmount(), findBags(subBag.getType())));
		}

		return bags;
	}
}
