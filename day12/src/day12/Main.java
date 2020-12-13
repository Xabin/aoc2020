package day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static final String INPUT_LOCATION = "C:\\b\\aoc2020\\day12\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day12FirstTask firstTask = new Day12FirstTask();

		System.out.println("First task: " + firstTask.calculateManhattanDistance(input));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day12SecondTask secondTask = new Day12SecondTask();

		System.out.println("Second task: " + secondTask.calculateManhattanDistance(input));
	}

	private static List<String> readInput() throws IOException {
		return Files.lines(Path.of(INPUT_LOCATION)).collect(Collectors.toList());
	}
}
