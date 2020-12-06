package day6;

import java.util.ArrayList;
import java.util.List;

public class Day6SecondTask {

	public int countYes(List<String> lines) {
		List<Group> groups = createGroups(lines);
		int numberOfYes = 0;
		
		for (Group group : groups) {
			List<String> persons = group.getPersons();
			String firstPerson = persons.get(0);
			
			for (char question : firstPerson.toCharArray()) {
				boolean everyoneYes = true;
				
				for (int i = 1; i < persons.size(); i++) {
					if (!persons.get(i).contains("" + question)) {
						everyoneYes = false;
					}
				}
				
				if (everyoneYes) {
					numberOfYes++;
				}
			}
			
		}
		
		return numberOfYes;
	}

	List<Group> createGroups(List<String> lines) {
		List<Group> groups = new ArrayList<>();
		Group group = new Group();

		for (String person : lines) {
			if (person.isEmpty()) {
				groups.add(group);
				group = new Group();
				continue;
			}

			group.addPerson(person);
		}

		return groups;
	}
}
