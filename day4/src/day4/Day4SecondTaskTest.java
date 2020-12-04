package day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Day4SecondTaskTest {
	private Day4SecondTask testee;

	private List<String> exampleInvalidPassports = Arrays.asList("eyr:1972 cid:100", //
			"hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926", //
			"", //
			"iyr:2019", //
			"hcl:#602927 eyr:1967 hgt:170cm", //
			"ecl:grn pid:012533040 byr:1946", //
			"", //
			"hcl:dab227 iyr:2012", //
			"ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277", //
			"", //
			"hgt:59cm ecl:zzz", //
			"eyr:2038 hcl:74454a iyr:2023", //
			"pid:3556412378 byr:2007", "");

	private List<String> exampleValidPassports = Arrays.asList(
			"pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980", //
			"hcl:#623a2f", //
			"", //
			"eyr:2029 ecl:blu cid:129 byr:1989", //
			"iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm", //
			"", //
			"hcl:#888785", //
			"hgt:164cm byr:2001 iyr:2015 cid:88", //
			"pid:545766238 ecl:hzl", //
			"eyr:2022", //
			"", //
			"iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719", "");

	@Test
	public void exampleInvalidPassports() {
		testee = new Day4SecondTask();

		assertEquals(0, testee.validPassports(exampleInvalidPassports));
	}

	@Test
	public void exampleValidPassports() {
		testee = new Day4SecondTask();

		assertEquals(4, testee.validPassports(exampleValidPassports));
	}

	@Test
	public void correctExtractionOfFields() {
		testee = new Day4SecondTask();
		String passport = "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719 ";

		assertEquals("2010", testee.extract(passport, "iyr"));
		assertEquals("158cm", testee.extract(passport, "hgt"));
		assertEquals("#b6652a", testee.extract(passport, "hcl"));
		assertEquals("blu", testee.extract(passport, "ecl"));
		assertEquals("1944", testee.extract(passport, "byr"));
		assertEquals("2021", testee.extract(passport, "eyr"));
		assertEquals("093154719", testee.extract(passport, "pid"));
	}

	@Test
	public void correctHeightValidation() {
		testee = new Day4SecondTask();

		assertTrue(testee.validHgt("hgt:158cm "));
		assertFalse(testee.validHgt("hgt:148cm "));
		assertTrue(testee.validHgt("hgt:60in "));
		assertFalse(testee.validHgt("hgt:50in "));
	}

	@Test
	public void correctHairColorValidation() {
		testee = new Day4SecondTask();

		assertTrue(testee.validHcl("hcl:#123abc "));
		assertFalse(testee.validHcl("hcl:#123abz "));
		assertFalse(testee.validHcl("hcl:123abc "));
		assertTrue(testee.validHcl("hcl:#623a2f "));
	}
}
