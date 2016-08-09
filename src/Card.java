import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Card {
	
	private static Map<String,Integer> NumericalValue;

	protected static enum Suites {
		SPADES, HEARTS, DIAMONDS, CLUBS
	}

	protected static enum Colors {
		BLACK, RED
	}

	private void createMap() {
		NumericalValue = new HashMap<>();
		NumericalValue.put("2",2);
		NumericalValue.put("3",3);
		NumericalValue.put("4",4);
		NumericalValue.put("5",5);
		NumericalValue.put("6",6);
		NumericalValue.put("7",7);
		NumericalValue.put("8",8);
		NumericalValue.put("9",9);
		NumericalValue.put("10",10);
		NumericalValue.put("J",11);
		NumericalValue.put("Q",12);
		NumericalValue.put("K",13);
		NumericalValue.put("A",14);

	}


	private int face;
	
	private Colors color;
	
	private Suites suite;
	
	
	/*
	 * 	Assessor functions
	 * 
	 */
	protected int getFace() {
		return this.face;
	}
	
	protected Colors getColor() {
		return this.color;
	}
	
	protected Suites getSuite() {
		return this.suite;
	}
	
	/*
	 * 	Enums for Suites and Colors
	 * 
	 */
	

	public Card (String Face, Suites suite) {
		createMap();
		this.face = NumericalValue.get(Face);
		this.suite = suite;
	}
	
}