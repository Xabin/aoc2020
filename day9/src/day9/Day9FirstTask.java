package day9;

import java.util.List;
import java.util.stream.Collectors;

public class Day9FirstTask {
	public long findFirstNoSum(List<String> inputAsText, int preambleLength) {
		List<Long> input = toLongList(inputAsText);

		int numberPositionToCheck = preambleLength;
		boolean invalidNumberFound = false;

		while (!invalidNumberFound) {
			long numberToCheck = input.get(numberPositionToCheck);

			invalidNumberFound = checkNumber(input, preambleLength, numberPositionToCheck, numberToCheck);
			
			if (invalidNumberFound) {
				return numberToCheck;
			}

			numberPositionToCheck++;
		}

		return 0;
	}

	public boolean checkNumber(List<Long> numbers, int preambleLength, int numberPositionToCheck,
			long numberToCheck) {
		for (int i = numberPositionToCheck - preambleLength; i < numberPositionToCheck; i++) {
			for (int j = numberPositionToCheck - preambleLength; j < numberPositionToCheck; j++) {
				long firstNumber = numbers.get(i);
				long secondNumber = numbers.get(j);

				if (firstNumber == secondNumber) {
					continue;
				}

				if (firstNumber + secondNumber == numberToCheck) {
					return false;
				}
			}
		}

		return true;
	}

	public List<Long> toLongList(List<String> inputAsText) {
		return inputAsText.stream().map(Long::parseLong).collect(Collectors.toList());
	}
}
