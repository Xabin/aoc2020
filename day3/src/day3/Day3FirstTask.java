package day3;

import java.util.List;

public class Day3FirstTask {
	private final char[][] terrainGrid;
	private final int columns;
	private final int rows;

	public Day3FirstTask(List<String> input) {
		terrainGrid = convertToGrid(input);
		columns = input.get(0).length();
		rows = input.size();
	}

	char[][] convertToGrid(List<String> input) {
		char[][] grid = new char[input.size()][input.get(0).length()];

		for (int i = 0; i < input.size(); i++) {
			String line = input.get(i);

			for (int j = 0; j < line.length(); j++) {
				grid[i][j] = line.charAt(j);
			}
		}

		return grid;
	}

	public int findTrees(int right, int down) {
		int trees = 0;
		int column = right % columns;
		
		for (int row = down; row < rows; row += down) {
			if (terrainGrid[row][column] == '#') {
				trees++;
			}
			
			column = (column + right) % columns;
		}
		
		return trees;
	}
}
