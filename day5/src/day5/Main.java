package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day5\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day5FirstTask firstTask = new Day5FirstTask();

		System.out.println("First task: " + firstTask.findHighestSeatId(input));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day5SecondTask secondTask = new Day5SecondTask();

		System.out.println("Second task: " + secondTask.findMissingSeatId(input));
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
