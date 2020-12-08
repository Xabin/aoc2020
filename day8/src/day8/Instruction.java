package day8;

public class Instruction {
	private Operation operation;
	private int nextInstruction;
	private boolean alreadyExecuted;

	public Instruction(Operation operation, int nextInstruction) {
		this.operation = operation;
		this.nextInstruction = nextInstruction;
		alreadyExecuted = false;
	}

	public boolean isAlreadyExecuted() {
		return alreadyExecuted;
	}

	public void setAlreadyExecuted(boolean alreadyExecuted) {
		this.alreadyExecuted = alreadyExecuted;
	}

	public int getNextInstruction() {
		return nextInstruction;
	}

	public void setNextInstruction(int nextInstruction) {
		this.nextInstruction = nextInstruction;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Instruction [operation=" + operation + ", nextInstruction=" + nextInstruction + ", alreadyExecuted="
				+ alreadyExecuted + "]";
	}
}
