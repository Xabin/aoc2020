package day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day9\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day9FirstTask firstTask = new Day9FirstTask();

		System.out.println("First task: " + firstTask.findFirstNoSum(input, 25));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day9SecondTask secondTask = new Day9SecondTask();

		System.out.println("Second task: " + secondTask.findEncryptionWeakness(input, 25));
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
