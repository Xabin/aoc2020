package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day1\\input.txt";

	public static void main(String[] args) throws IOException {
		List<String> input = readInput();
		List<Integer> firstTaskResult = new Day1().findSumTwoNumbers(input, 2020);

		System.out.println("First task, result: " + firstTaskResult);
		System.out.println("First task, product: " + multiply(firstTaskResult));

		List<Integer> secondTaskResult = new Day1().findSumThreeNumbers(input, 2020);

		System.out.println("Second task, result: " + secondTaskResult);
		System.out.println("Second task, product: " + multiply(secondTaskResult));
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}

	private static int multiply(List<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		
		int result = 1;

		for (int number : numbers) {
			result *= number;
		}

		return result;
	}
}
