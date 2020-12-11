package day11;

import java.util.Arrays;
import java.util.List;

public class Day11FirstTask {
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
				if (seats[i][j] == 'L' //
						&& seatEmpty(seats, i - 1, j - 1) //
						&& seatEmpty(seats, i - 1, j) //
						&& seatEmpty(seats, i - 1, j + 1) //
						&& seatEmpty(seats, i, j - 1) //
						&& seatEmpty(seats, i, j + 1) //
						&& seatEmpty(seats, i + 1, j - 1) //
						&& seatEmpty(seats, i + 1, j) //
						&& seatEmpty(seats, i + 1, j + 1)) {
					updatedSeats[i][j] = '#';
				} else if (seats[i][j] == '#') {
					int occupied = 0;

					if (seats[i - 1][j - 1] == '#') {
						occupied++;
					}

					if (seats[i - 1][j] == '#') {
						occupied++;
					}

					if (seats[i - 1][j + 1] == '#') {
						occupied++;
					}

					if (seats[i][j - 1] == '#') {
						occupied++;
					}

					if (seats[i][j + 1] == '#') {
						occupied++;
					}

					if (seats[i + 1][j - 1] == '#') {
						occupied++;
					}

					if (seats[i + 1][j] == '#') {
						occupied++;
					}

					if (seats[i + 1][j + 1] == '#') {
						occupied++;
					}

					if (occupied >= 4) {
						updatedSeats[i][j] = 'L';
					}
				}
			}
		}

		return updatedSeats;
	}

	private boolean seatEmpty(char[][] seats, int i, int j) {
		return seats[i][j] == 'L' || seats[i][j] == '.';
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
