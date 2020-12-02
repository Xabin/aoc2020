package day2;

public class Day2FirstTask {
	public boolean passwordValid(int minimumOccurrances, int maximumOccurrances, char requiredCharacter,
			String password) {
		int occurrances = 0;

		for (char character : password.toCharArray()) {
			if (character == requiredCharacter) {
				occurrances++;
			}
		}

		return occurrances >= minimumOccurrances && occurrances <= maximumOccurrances;
	}
}
