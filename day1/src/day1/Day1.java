package day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
	public List<Integer> findSumTwoNumbers(List<String> numbers, int sum) {
		List<Integer> firstNumbers = convertToInt(numbers);

		for (int first : firstNumbers) {
			List<Integer> secondNumbers = convertToInt(numbers);
			secondNumbers.remove(Integer.valueOf(first));

			for (int second : secondNumbers) {
				if (first + second == sum) {
					return Arrays.asList(first, second);
				}
			}
		}

		return null;
	}

	public List<Integer> findSumThreeNumbers(List<String> numbers, int sum) {
		List<Integer> firstNumbers = convertToInt(numbers);

		for (int first : firstNumbers) {
			List<Integer> secondNumbers = convertToInt(numbers);
			secondNumbers.remove(Integer.valueOf(first));

			for (int second : secondNumbers) {
				List<Integer> thirdNumbers = convertToInt(numbers);
				thirdNumbers.remove(Integer.valueOf(first));
				thirdNumbers.remove(Integer.valueOf(second));

				for (int third : thirdNumbers) {
					if (first + second + third == sum) {
						return Arrays.asList(first, second, third);
					}
				}
			}
		}

		return null;
	}

	private List<Integer> convertToInt(List<String> lines) {
		return lines.stream().map(Integer::valueOf).collect(Collectors.toList());
	}
}
