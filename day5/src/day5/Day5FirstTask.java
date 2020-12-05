package day5;

import java.util.List;

public class Day5FirstTask {
	int getRow(String seat) {
		String rowAsString = seat.substring(0, 7);
		String rowAsBinary = toBinaryString(rowAsString);

		return Integer.parseInt(rowAsBinary, 2);
	}

	int getColumn(String seat) {
		String columnAsString = seat.substring(7, 10);
		String columnAsBinary = toBinaryString(columnAsString);

		return Integer.parseInt(columnAsBinary, 2);
	}

	private String toBinaryString(String columnAsString) {
		return columnAsString.replace('F', '0').replace('B', '1').replace('L', '0').replace('R', '1');
	}

	public int getSeatId(String seat) {
		return getRow(seat) * 8 + getColumn(seat);
	}

	public int findHighestSeatId(List<String> seats) {
		int highest = 0;

		for (String seat : seats) {
			int seatId = getSeatId(seat);

			if (seatId > highest) {
				highest = seatId;
			}
		}

		return highest;
	}
}
