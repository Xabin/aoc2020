package day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6FirstTask {

	public int countYes(List<String> lines) {
		Set<String> group = new HashSet<>();
		int numberOfYes = 0;

		for (String line : lines) {
			if (line.isEmpty()) {
				numberOfYes += group.size();
				group = new HashSet<>();
				continue;
			}

			for (char character : line.toCharArray()) {
				group.add("" + character);
			}
		}

		return numberOfYes;
	}

}
