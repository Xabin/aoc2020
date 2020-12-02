package day2;

public final class Utils {
	private Utils() {
		
	}
	
	public static int extractFirstPosition(String line) {
		return Integer.valueOf(line.substring(0, line.indexOf('-')));
	}
	
	public static int extractSecondPosition(String line) {
		return Integer.valueOf(line.substring(line.indexOf('-') + 1, line.indexOf(' ')));
	}
	
	public static char extractRequiredCharacter(String line) {
		return line.substring(line.indexOf(' ')).charAt(1);
	}
	
	public static String extractPassword(String line) {
		return line.substring(line.indexOf(':')).substring(2);
	}

}
