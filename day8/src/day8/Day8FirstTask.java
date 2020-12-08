package day8;

import java.util.ArrayList;
import java.util.List;

public class Day8FirstTask {
	public int findAccumulator(List<String> instructionsAsText) {
		List<Instruction> instructions = parseInstructions(instructionsAsText);
		int accumulator = 0;
		
		for (int i = 0; i < instructions.size(); i++) {
			Instruction instruction = instructions.get(i);
			
			if (instruction.isAlreadyExecuted()) {
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
		}
		
		return accumulator;
	}

	List<Instruction> parseInstructions(List<String> instructionsAsText) {
		List<Instruction> instructions = new ArrayList<>();

		for (String instructionAsText : instructionsAsText) {
			String[] split = instructionAsText.split(" ");
			instructions.add(new Instruction(toOperation(split[0]), Integer.valueOf(split[1])));
		}

		return instructions;
	}

	private Operation toOperation(String operation) {
		switch (operation) {
		case "nop":
			return Operation.NOP;
		case "acc":
			return Operation.ACC;
		case "jmp":
			return Operation.JMP;
		}

		return null;
	}
}
