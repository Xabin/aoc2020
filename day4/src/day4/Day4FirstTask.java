package day4;

import java.util.ArrayList;
import java.util.List;

public class Day4FirstTask {
	public int validPassports(List<String> unparsedPassports) {
		List<String> passports = parsePassports(unparsedPassports);

		return countValidPassports(passports);
	}

	private List<String> parsePassports(List<String> unparsedPassports) {
		List<String> passports = new ArrayList<>();
		StringBuilder builder = new StringBuilder();

		for (String unparsedPassport : unparsedPassports) {
			if (!unparsedPassport.isEmpty()) {
				if (!builder.toString().isEmpty()) {
					builder.append(' ');
				}

				builder.append(unparsedPassport);
			} else {
				String passport = builder.toString();
				passports.add(passport);
				builder = new StringBuilder();
			}
		}

		return passports;
	}

	private int countValidPassports(List<String> passports) {
		int validPassports = 0;

		for (String passport : passports) {
			if (passport.contains("ecl:") //
					&& passport.contains("pid:") //
					&& passport.contains("eyr:") //
					&& passport.contains("hcl:") //
					&& passport.contains("byr:") //
					&& passport.contains("iyr:") //
					&& passport.contains("hgt:")) {
				validPassports++;
			}
		}

		return validPassports;
	}
}
