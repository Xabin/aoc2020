package day4;

import java.util.ArrayList;
import java.util.List;

public class Day4SecondTask {
	public int validPassports(List<String> unparsedPassports) {
		List<String> potentialPassports = parsePassports(unparsedPassports);
		List<String> passportsWithCorrectFields = filterMissingFields(potentialPassports);

		return countValidPassports(passportsWithCorrectFields);
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
				builder.append(' ');
				String passport = builder.toString();
				passports.add(passport);
				builder = new StringBuilder();
			}
		}

		return passports;
	}

	private List<String> filterMissingFields(List<String> passports) {
		List<String> allRequiredFieldsPresent = new ArrayList<>();

		for (String passport : passports) {
			if (passport.contains("ecl:") //
					&& passport.contains("pid:") //
					&& passport.contains("eyr:") //
					&& passport.contains("hcl:") //
					&& passport.contains("byr:") //
					&& passport.contains("iyr:") //
					&& passport.contains("hgt:")) {
				allRequiredFieldsPresent.add(passport);
			}
		}

		return allRequiredFieldsPresent;
	}

	private int countValidPassports(List<String> passports) {
		int validPassports = 0;

		for (String passport : passports) {
			if (validByr(passport) && //
					validIyr(passport) && //
					validEyr(passport) && //
					validHgt(passport) && //
					validHcl(passport) && //
					validEcl(passport) && //
					validPid(passport)) {
				validPassports++;
			}
		}

		return validPassports;
	}

	private boolean validByr(String passport) {
		int byr = Integer.valueOf(extract(passport, "byr"));

		return byr >= 1920 && byr <= 2002;
	}

	private boolean validIyr(String passport) {
		int iyr = Integer.valueOf(extract(passport, "iyr"));

		return iyr >= 2010 && iyr <= 2020;
	}

	private boolean validEyr(String passport) {
		int eyr = Integer.valueOf(extract(passport, "eyr"));

		return eyr >= 2020 && eyr <= 2030;
	}

	boolean validHgt(String passport) {
		String hgt = extract(passport, "hgt");

		if (!hgt.contains("cm") && !hgt.contains("in")) {
			return false;
		}

		int height = Integer.valueOf(hgt.substring(0, hgt.length() - 2));

		if (hgt.contains("cm")) {
			return height >= 150 && height <= 193;
		} else if (hgt.contains("in")) {
			return height >= 59 && height <= 76;
		}

		return false;
	}

	boolean validHcl(String passport) {
		String hcl = extract(passport, "hcl");

		if (!hcl.startsWith("#") || hcl.length() != 7) {
			return false;
		}

		return hcl.substring(1).matches("[0-9a-f]*");
	}

	private boolean validEcl(String passport) {
		String ecl = extract(passport, "ecl");

		switch (ecl) {
		case "amb":
		case "blu":
		case "brn":
		case "gry":
		case "grn":
		case "hzl":
		case "oth":
			return true;
		}

		return false;
	}

	private boolean validPid(String passport) {
		String pid = extract(passport, "pid");

		return pid.length() == 9 && pid.matches("\\d*");
	}

	String extract(String passport, String field) {
		String fieldPlusRestOfString = passport.substring(passport.indexOf(field) + 4);
		return fieldPlusRestOfString.substring(0, fieldPlusRestOfString.indexOf(' '));
	}
}
