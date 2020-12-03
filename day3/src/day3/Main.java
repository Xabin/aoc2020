package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day3\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day3FirstTask firstTask = new Day3FirstTask(input);

		System.out.println("First task: " + firstTask.findTrees(3, 1));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day3FirstTask firstTask = new Day3FirstTask(input);
		int trees = 1;

		trees *= firstTask.findTrees(1, 1);
		trees *= firstTask.findTrees(3, 1);
		trees *= firstTask.findTrees(5, 1);
		trees *= firstTask.findTrees(7, 1);
		trees *= firstTask.findTrees(1, 2);

		System.out.println("Second task: " + trees);
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
