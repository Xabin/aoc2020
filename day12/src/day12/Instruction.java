package day12;

public class Instruction {
	public Action action;
	public int value;
	
	public Instruction(String instruction) {
		action = Action.toAction(instruction.charAt(0));
		value = Integer.parseInt(instruction.substring(1));
	}

	@Override
	public String toString() {
		return "Instruction [action=" + action + ", value=" + value + "]";
	}
}