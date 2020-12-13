package day12;

import java.util.List;

public class Day12SecondTask {
	private int shipNorth = 0;
	private int shipEast = 0;
	int waypointNorth = 1;
	int waypointEast = 10;

	public int calculateManhattanDistance(List<String> instructionsAsString) {
		for (Instruction instruction : Day12FirstTask.parseInstructions(instructionsAsString)) {
			performInstruction(instruction);
		}

		return Math.abs(shipNorth) + Math.abs(shipEast);
	}

	private void performInstruction(Instruction instruction) {
		switch (instruction.action) {
		case NORTH:
		case EAST:
		case SOUTH:
		case WEST:
			moveWaypoint(instruction.action, instruction.value);
			break;
		case FORWARD:
			moveShip(instruction.value);
			break;
		case LEFT:
		case RIGHT:
			turnWaypoint(instruction.action, instruction.value);
			break;
		}
	}

	void moveWaypoint(Action action, int steps) {
		switch (action) {
		case NORTH:
			waypointNorth += steps;
			break;
		case EAST:
			waypointEast += steps;
			break;
		case SOUTH:
			waypointNorth -= steps;
			break;
		case WEST:
			waypointEast -= steps;
			break;
		}
	}

	private void moveShip(int steps) {
		for (int i = 0; i < steps; i++) {
			shipNorth += waypointNorth;
			shipEast += waypointEast;
		}
	}

	void turnWaypoint(Action action, int degrees) {
		int turns = degrees / 90;

		for (int i = 0; i < turns; i++) {
			if (action == Action.RIGHT) {
				turnRight();
			} else {
				turnLeft();
			}
		}
	}

	// 10 east 4 north -> 4 east -10 north
	// 4 east -10 north -> -10 east -4 north
	// -10 east -4 north -> -4 east 10 north
	// -4 east 10 north -> 10 east 4 north
	private void turnRight() {
		int previousEast = waypointEast;
		waypointEast = waypointNorth;
		waypointNorth = -1 * previousEast;
	}

	private void turnLeft() {
		int previousEast = waypointEast;
		waypointEast = -1 * waypointNorth;
		waypointNorth = previousEast;
	}
}
