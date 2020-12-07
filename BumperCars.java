package amusementPark;

public class BumperCars extends Attraction {
	private int fatalCrashes;
	private int speed;
	
	public BumperCars(int maxPlayers) {
		super(maxPlayers);
	}
	
	public void runAttraction() {
		super.addPlayers();
	}
	
	public int getFatalCrashes() {
		return fatalCrashes;
	}
	
	public String toString() {
		return "yep";
	}
}
