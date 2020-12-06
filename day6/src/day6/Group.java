package day6;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private List<String> persons = new ArrayList<>();

	public void addPerson(String person) {
		persons.add(person);
	}

	public List<String> getPersons() {
		return persons;
	}

	@Override
	public String toString() {
		return "Group [persons=" + persons + "]";
	}
}
