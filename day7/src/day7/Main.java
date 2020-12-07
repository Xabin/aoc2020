package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day7\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		List<String> input = readInput();
		Day7FirstTask firstTask = new Day7FirstTask();

		firstTask.createInitialRules(input);
		firstTask.createFullRules();
		
		System.out.println("First task: " + firstTask.howManyBagsCanCarry("shiny gold"));
	}

	private static void secondTask() throws IOException {
		List<String> input = readInput();
		Day7SecondTask secondTask = new Day7SecondTask();
		Day7FirstTask firstTask = new Day7FirstTask();
		firstTask.createInitialRules(input);
		List<Bag> fullRules = firstTask.createFullRules();
		
		Bag shinyGoldBag = secondTask.filterRule(fullRules, "shiny gold");

		System.out.println("Second task: " + secondTask.countBagsInside(shinyGoldBag));
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
