package day12;

public enum Action {
	NORTH, EAST, SOUTH, WEST, RIGHT, LEFT, FORWARD;

	static Action toAction(char action) {
		switch (action) {
		case 'N':
			return NORTH;
		case 'E':
			return EAST;
		case 'S':
			return SOUTH;
		case 'W':
			return WEST;
		case 'R':
			return RIGHT;
		case 'L':
			return LEFT;
		case 'F':
			return FORWARD;
		default:
			return null;
		}
	}

	static Action turn(Action currentDirection, Action turnDirection, int turns) {
		Action newDirection = currentDirection;

		for (int i = 0; i < turns; i++) {
			newDirection = turn(newDirection, turnDirection);
		}

		return newDirection;
	}

	private static Action turn(Action newDirection, Action turnDirection) {
		switch (turnDirection) {
		case RIGHT:
			switch (newDirection) {
			case NORTH:
				return Action.EAST;
			case EAST:
				return Action.SOUTH;
			case SOUTH:
				return Action.WEST;
			case WEST:
				return Action.NORTH;
			}
		case LEFT:
			switch (newDirection) {
			case NORTH:
				return Action.WEST;
			case EAST:
				return Action.NORTH;
			case SOUTH:
				return Action.EAST;
			case WEST:
				return Action.SOUTH;
			}
		}
		
		return null;
	}
}
