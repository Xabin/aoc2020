package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day4\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day4FirstTask firstTask = new Day4FirstTask();

		System.out.println("First task: " + firstTask.validPassports(input));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day4SecondTask secondTask = new Day4SecondTask();

		System.out.println("Second task: " + secondTask.validPassports(input));
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
