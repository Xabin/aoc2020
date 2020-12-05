package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5SecondTask {
	private Day5FirstTask firstTask = new Day5FirstTask();

	public int findMissingSeatId(List<String> seats) {
		List<Integer> seatIds = new ArrayList<>();
		seats.forEach(seat -> seatIds.add(firstTask.getSeatId(seat)));

		Collections.sort(seatIds);
		int nonExistantSeatId = seatIds.get(0);

		for (Integer seatId : seatIds) {
			if (seatId != nonExistantSeatId) {
				return nonExistantSeatId;
			}

			nonExistantSeatId++;
		}

		return -1;
	}
}
