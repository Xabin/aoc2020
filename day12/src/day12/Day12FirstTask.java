package day12;

import java.util.List;
import java.util.stream.Collectors;

public class Day12FirstTask {
	private Action direction = Action.EAST;
	private int north = 0;
	private int east = 0;

	public int calculateManhattanDistance(List<String> instructionsAsString) {
		for (Instruction instruction : parseInstructions(instructionsAsString)) {
			performInstruction(instruction);
		}

		return Math.abs(north) + Math.abs(east);
	}

	private void performInstruction(Instruction instruction) {
		switch (instruction.action) {
		case NORTH:
		case EAST:
		case SOUTH:
		case WEST:
		case FORWARD:
			move(instruction.action, instruction.value);
			break;
		case LEFT:
		case RIGHT:
			turn(instruction.action, instruction.value);
			break;
		}
	}

	private void move(Action action, int steps) {
		switch (action) {
		case NORTH:
			north += steps;
			break;
		case EAST:
			east += steps;
			break;
		case SOUTH:
			north -= steps;
			break;
		case WEST:
			east -= steps;
			break;
		case FORWARD:
			move(direction, steps);
			break;
		}
	}

	private void turn(Action action, int degrees) {
		int turns = degrees / 90;

		direction = Action.turn(direction, action, turns);
	}

	public static List<Instruction> parseInstructions(List<String> instructionsAsString) {
		return instructionsAsString.stream().map(Instruction::new).collect(Collectors.toList());
	}
}
