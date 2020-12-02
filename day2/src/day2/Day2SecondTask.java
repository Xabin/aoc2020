package day2;

public class Day2SecondTask {
	public boolean passwordValid(int firstPosition, int secondPosition, char requiredCharacter, String password) {
		boolean firstPositionValid = charAtPosition(firstPosition, requiredCharacter, password);
		boolean secondPositionValid = charAtPosition(secondPosition, requiredCharacter, password);

		if (firstPositionValid && secondPositionValid) {
			return false;
		}

		return firstPositionValid || secondPositionValid;
	}

	private boolean charAtPosition(int position, char character, String line) {
		return line.charAt(position - 1) == character;
	}
}
