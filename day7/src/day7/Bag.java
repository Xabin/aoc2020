package day7;

import java.util.Map;

public class Bag {
	private String type;
	private int amount;
	private Map<String, Bag> bags;

	public Bag(String type, int amount, Map<String, Bag> bags) {
		this.type = type;
		this.amount = amount;
		this.bags = bags;
	}

	public Map<String, Bag> getBags() {
		return bags;
	}

	public void setBags(Map<String, Bag> bags) {
		this.bags = bags;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Bag [type=" + type + ", amount=" + amount + ", bags=" + bags + "]";
	}
}
