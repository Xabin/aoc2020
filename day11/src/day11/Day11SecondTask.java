package day11;

import java.util.Arrays;
import java.util.List;

public class Day11SecondTask {
	public int findStableSeatCombinations(List<String> seatsAsStrings) {
		char[][] seats = createSeatArray(seatsAsStrings);

		boolean stableStateFound = false;

		while (!stableStateFound) {
			char[][] previousSeats = Arrays.stream(seats).map(row -> row.clone()).toArray(char[][]::new);
			seats = performOneRound(previousSeats);

			if (Arrays.deepEquals(seats, previousSeats)) {
				stableStateFound = true;
			}
		}

		return countOccupiedSeats(seats);
	}

	private char[][] performOneRound(char[][] seats) {
		char[][] updatedSeats = Arrays.stream(seats).map(row -> row.clone()).toArray(char[][]::new);

		for (int i = 1; i < seats.length - 1; i++) {
			for (int j = 1; j < seats[0].length - 1; j++) {
				if (seats[i][j] == 'L' && canSeeNoOccupiedSeats(seats, i, j)) {
					updatedSeats[i][j] = '#';
				} else if (seats[i][j] == '#') {
					int occupied = 0;

					for (Direction direction : Direction.values()) {
						if (!canSeeNoOccupiedSeats(seats, i, j, direction)) {
							occupied++;
						}
					}

					if (occupied >= 5) {
						updatedSeats[i][j] = 'L';
					}
				}
			}
		}

		return updatedSeats;
	}

	private boolean canSeeNoOccupiedSeats(char[][] seats, int i, int j) {
		for (Direction direction : Direction.values()) {
			if (!canSeeNoOccupiedSeats(seats, i, j, direction)) {
				return false;
			}
		}

		return true;
	}

	private boolean canSeeNoOccupiedSeats(char[][] seats, int centerI, int centerJ, Direction direction) {
		int i = nextIInDirection(centerI, direction);
		int j = nextJInDirection(centerJ, direction);

		if (i == -1 || j == -1 || i == seats.length || j == seats[0].length) {
			return false;
		}

		if (seats[i][j] == 'L') {
			return true;
		} else if (seats[i][j] == '#') {
			return false;
		}

		return canSeeNoOccupiedSeats(seats, i, j, direction);
	}

	private int nextIInDirection(int centerI, Direction direction) {
		switch (direction) {
		case NORTHWEST:
			return centerI - 1;
		case NORTH:
			return centerI - 1;
		case NORTHEAST:
			return centerI - 1;
		case WEST:
			return centerI;
		case EAST:
			return centerI;
		case SOUTHWEST:
			return centerI + 1;
		case SOUTH:
			return centerI + 1;
		case SOUTHEAST:
			return centerI + 1;
		}

		return -1;
	}

	private int nextJInDirection(int centerJ, Direction direction) {
		switch (direction) {
		case NORTHWEST:
			return centerJ - 1;
		case NORTH:
			return centerJ;
		case NORTHEAST:
			return centerJ + 1;
		case WEST:
			return centerJ - 1;
		case EAST:
			return centerJ + 1;
		case SOUTHWEST:
			return centerJ - 1;
		case SOUTH:
			return centerJ;
		case SOUTHEAST:
			return centerJ + 1;
		}

		return -1;
	}

	private int countOccupiedSeats(char[][] seats) {
		int occupiedSeats = 0;

		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (seats[i][j] == '#') {
					occupiedSeats++;
				}
			}
		}

		return occupiedSeats;
	}

	private char[][] createSeatArray(List<String> seatsAsStrings) {
		char[][] seatArray = new char[seatsAsStrings.size()][seatsAsStrings.get(0).length()];

		for (int i = 0; i < seatsAsStrings.size(); i++) {
			for (int j = 0; j < seatsAsStrings.get(0).length(); j++) {
				seatArray[i][j] = seatsAsStrings.get(i).charAt(j);
			}
		}

		return seatArray;
	}
}
