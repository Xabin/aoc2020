package day9;

import java.util.List;

public class Day9SecondTask {
	private Day9FirstTask firstTask = new Day9FirstTask();

	public long findEncryptionWeakness(List<String> inputAsText, int preambleLength) {
		List<Long> input = firstTask.toLongList(inputAsText);
		long invalidNumber = firstTask.findFirstNoSum(inputAsText, preambleLength);
		int startPosition = 0;
		boolean weaknessFound = false;

		while (!weaknessFound) {
			int i = startPosition;
			long firstNumber = input.get(i++);
			long smallestNumber = firstNumber;
			long largestNumber = smallestNumber;
			long nextNumber = input.get(i++);
			
			if (nextNumber > largestNumber) {
				largestNumber = nextNumber;
			}
			
			if (nextNumber < smallestNumber) {
				smallestNumber = nextNumber;
			}
			
			long sum = firstNumber + nextNumber;

			if (sum == invalidNumber) {
				return smallestNumber + largestNumber;
			}
			
			while (sum < invalidNumber) {
				nextNumber = input.get(i++);
				
				if (nextNumber > largestNumber) {
					largestNumber = nextNumber;
				}
				
				if (nextNumber < smallestNumber) {
					smallestNumber = nextNumber;
				}
				
				sum += nextNumber;

				if (sum == invalidNumber) {
					return smallestNumber + largestNumber;
				}
			}

			startPosition++;
		}

		return 0;
	}
}
