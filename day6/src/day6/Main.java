package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day6\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day6FirstTask firstTask = new Day6FirstTask();

		System.out.println("First task: " + firstTask.countYes(input));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day6SecondTask secondTask = new Day6SecondTask();

		System.out.println("Second task: " + secondTask.countYes(input));
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
