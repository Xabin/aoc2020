package day8;

import java.util.List;

public class Day8SecondTask {
	private Day8FirstTask firstTask = new Day8FirstTask();

	public int findAccumulator(List<String> instructionsAsText) {
		int accumulator = run(instructionsAsText);

		return accumulator;
	}

	private int run(List<String> instructionsAsText) {
		int accumulator = 0;
		boolean executionInterrupted = true;
		int instructionSwitchLocation = -1;

		while (executionInterrupted) {
			int instructionCounter = 0;
			boolean alreadySwitched = false;
			accumulator = 0;
			executionInterrupted = false;
			List<Instruction> instructions = firstTask.parseInstructions(instructionsAsText);

			for (int i = 0; i < instructions.size(); i++) {
				Instruction instruction = instructions.get(i);

				if (instruction.isAlreadyExecuted()) {
					executionInterrupted = true;
					break;
				}

				switch (instruction.getOperation()) {
				case JMP:
					if (!alreadySwitched && instructionCounter > instructionSwitchLocation) {
						instruction.setOperation(Operation.NOP);
						instructionSwitchLocation = instructionCounter;
						alreadySwitched = true;
					}
					break;
				case NOP:
					if (!alreadySwitched && instructionCounter > instructionSwitchLocation) {
						instruction.setOperation(Operation.JMP);
						instructionSwitchLocation = instructionCounter;
						alreadySwitched = true;
					}
					break;
				}

				switch (instruction.getOperation()) {
				case ACC:
					accumulator += instruction.getNextInstruction();
					break;
				case JMP:
					i += instruction.getNextInstruction() - 1;
					break;
				case NOP:
					break;
				}

				instruction.setAlreadyExecuted(true);
				instructionCounter++;
			}
		}

		return accumulator;
	}
}
