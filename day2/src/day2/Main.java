package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String INPUT_LOCATION = "C:\\dev\\code\\day2\\input.txt";

	public static void main(String[] args) throws IOException {
		firstTask();
		secondTask();
	}

	private static void firstTask() throws IOException {
		Day2FirstTask firstTask = new Day2FirstTask();
		List<String> input = readInput();
		int validPasswords = 0;
		
		for (String line : input) {
			int minimumOccurrances = Utils.extractFirstPosition(line);
			int maximumOccurrances = Utils.extractSecondPosition(line);
			char requiredCharacter = Utils.extractRequiredCharacter(line);
			String password = Utils.extractPassword(line);
			
			if (firstTask.passwordValid(minimumOccurrances, maximumOccurrances, requiredCharacter, password)) {
				validPasswords++;
			}
		}
		
		System.out.println("First task: Number of valid passwords: " + validPasswords);
	}

	/**
	 * @throws IOException
	 */
	private static void secondTask() throws IOException {
		Day2SecondTask secondTask = new Day2SecondTask();
		List<String> input = readInput();
		int validPasswords = 0;
		
		for (String line : input) {
			int firstPosition = Utils.extractFirstPosition(line);
			int secondPosition = Utils.extractSecondPosition(line);
			char requiredCharacter = Utils.extractRequiredCharacter(line);
			String password = Utils.extractPassword(line);
			
			if (secondTask.passwordValid(firstPosition, secondPosition, requiredCharacter, password)) {
				validPasswords++;
			}
		}
		
		System.out.println("Second task: Number of valid passwords: " + validPasswords);
	}

	private static List<String> readInput() throws IOException {
		List<String> lines = new ArrayList<>();

		Files.lines(Path.of(INPUT_LOCATION)).forEach(lines::add);

		return lines;
	}
}
