package day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day10\\input.txt";

	public static void main(String[] args) throws IOException {
		secondTask();
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day10SecondTask secondTask = new Day10SecondTask();

		System.out.println("Second task: " + secondTask.findArrangements(input));
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
