package amusementPark;

import java.util.ArrayList;
import java.util.Random;

public abstract class Attraction {
	private ArrayList<String> players = new ArrayList<>();
	private ArrayList<String> deadPlayers = new ArrayList<>();
	private int numPlayers = players.size();
	private int numDeadPlayers = deadPlayers.size();
	private int maxPlayersPerRide;
	private int risk;
	
	private Random rand = new Random();
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public int getMaxPlayersPerRide() {
		return maxPlayersPerRide;
	}
	
	public void calculateRisk(int numRisk) {
		int pplDead = numPlayers * numRisk / 100;
		
		for (int i = 0; i<pplDead; i++) {
			int deadPerson = rand.nextInt(numPlayers);
			String deadPersonName = players.get(deadPerson);
			
			players.remove(deadPerson);
			deadPlayers.add(deadPersonName);
		}
		
	}

	public void addPlayers(int numberPlayers) {
		for (int i = 1; i <= numberPlayers; i++) {
			if (i < 10) 
				players.add("Player " + 0 + i);
			else 
				players.add("Player " + i);
		}
	}
	
	public void printPlayers() {
		String statement = "";
		for (int i = 0; i < numPlayers; i++) {
			statement += players.get(i) + ", ";
			
			if ((i+1) % 20 == 0) 
				statement += "\n";			
		}
		
		System.out.println(statement);
	}
	
	public void namePlayer(String name) {
		name = "[" + name + "]";
		players.set(0, name);
	}
	
	public abstract void runAttraction();
	
	public abstract String toString();
	
}
