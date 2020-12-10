package day10;

import java.util.Arrays;
import java.util.List;

public class Day10SecondTask {
	private int[] adapters;

	public long findArrangements(List<String> adaptersAsText) {
		adapters = toSortedIntArrayWithDeviceAdapter(adaptersAsText);

		Arrays.stream(adapters).forEach(System.out::println);

		return findCombinations(0, 0);
	}

	private int[] toSortedIntArrayWithDeviceAdapter(List<String> adaptersAsText) {
		int[] adapters = new int[adaptersAsText.size() + 1];

		for (int i = 0; i < adaptersAsText.size(); i++) {
			adapters[i] = Integer.parseInt(adaptersAsText.get(i));
		}

		adapters[adapters.length - 1] = Arrays.stream(adapters).max().getAsInt() + 3;
		Arrays.sort(adapters);

		return adapters;
	}

	private long findCombinations(int currentValue, int nextPosition) {
		if (nextPosition == adapters.length) {
			return 1;
		}

		long combinations = 0;
		int nextValue = adapters[nextPosition];

		if (nextPosition + 3 < adapters.length //
				&& nextValue - currentValue == 1 //
				&& adapters[nextPosition + 1] - adapters[nextPosition] == 1 //
				&& adapters[nextPosition + 2] - adapters[nextPosition + 1] == 1 //
				&& adapters[nextPosition + 3] - adapters[nextPosition + 2] == 3) {
			combinations += 4 * findCombinations(adapters[nextPosition + 2], nextPosition + 3);
		} else if (nextPosition + 2 < adapters.length //
				&& nextValue - currentValue == 1 //
				&& adapters[nextPosition + 1] - adapters[nextPosition] == 1 //
				&& adapters[nextPosition + 2] - adapters[nextPosition + 1] == 3) {
			combinations += 2 * findCombinations(adapters[nextPosition + 1], nextPosition + 2);
		} else if (nextValue - currentValue == 1 || nextValue - currentValue == 2) {
			combinations += findCombinations(nextValue, nextPosition + 1);
			combinations += findCombinations(currentValue, nextPosition + 1);
		} else if (nextValue - currentValue == 3) {
			combinations += findCombinations(nextValue, nextPosition + 1);
		}

		return combinations;
	}
}
