package day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UtilsTest {
	@Test
	public void validMinimumOccurrances() {
		assertEquals(2, Utils.extractFirstPosition("2-7 p: pbhhzpmppb"));
		assertEquals(10, Utils.extractFirstPosition("10-11 r: rrrrrrrrrrkr"));
	}

	@Test
	public void validMaximumOccurrances() {
		assertEquals(7, Utils.extractSecondPosition("2-7 p: pbhhzpmppb"));
		assertEquals(11, Utils.extractSecondPosition("10-11 r: rrrrrrrrrrkr"));
	}

	@Test
	public void validRequiredCharacter() {
		assertEquals('p', Utils.extractRequiredCharacter("2-7 p: pbhhzpmppb"));
		assertEquals('r', Utils.extractRequiredCharacter("10-11 r: rrrrrrrrrrkr"));
	}

	@Test
	public void validPassword() {
		assertEquals("pbhhzpmppb", Utils.extractPassword("2-7 p: pbhhzpmppb"));
		assertEquals("rrrrrrrrrrkr", Utils.extractPassword("10-11 r: rrrrrrrrrrkr"));
	}
}
