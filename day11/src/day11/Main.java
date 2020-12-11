package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day11\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day11FirstTask firstTask = new Day11FirstTask();

		System.out.println("First task: " + firstTask.findStableSeatCombinations(input));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day11SecondTask secondTask = new Day11SecondTask();

		System.out.println("Second task: " + secondTask.findStableSeatCombinations(input));
	}

	private static List<String> readInput() throws IOException {
		return Files.lines(Path.of(INPUT_LOCATION)).collect(Collectors.toList());
	}
}
