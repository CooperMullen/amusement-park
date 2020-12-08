package amusementPark;

import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author dan
 * This class calculates the number of players in a given attraction, as well as computes how many get eliminated
 
 * edits: I took out the abstract part of the class because i needed some of the objects from this class for the tester class
 (also screw abstract classes)
 */
public class Attraction {
	private static ArrayList<String> players = new ArrayList<>();
	private static ArrayList<String> deadPlayers = new ArrayList<>();
	private int totalPlayers;
	private int maxPlayersPerRide;
	
	private Random rand = new Random();
	
	public static ArrayList<String> getPlayers() {
		return players;
	}
	
	public static ArrayList<String> getDeadPlayers() {
		return deadPlayers;
	}
	
	public static int numAlivePlayers() {
		return players.size();
	}
	
	public static int numDeadPlayers() {
		return deadPlayers.size();
	}
	
	public int totalPlayers() {
		return totalPlayers;
	}
	public int getMaxPlayersPerRide() {
		return maxPlayersPerRide;
	}
	
	public void calculateDead(int numRisk) {
		int pplDead = numAlivePlayers() * numRisk / 100;
		
		for (int i = 0; i < pplDead; i++) {
			int deadPerson = rand.nextInt(numAlivePlayers());
			String deadPersonName = players.get(deadPerson);
			
			players.remove(deadPerson);
			deadPlayers.add(deadPersonName);
			
			players.sort(String::compareToIgnoreCase);
			deadPlayers.sort(String::compareToIgnoreCase);
			
		}
		
	}

	public void printAlivePlayers() {
		String statement = "Survived: \n";
		for (int i = 0; i < numAlivePlayers(); i++) {
			statement += players.get(i) + ", ";
			
			if ((i+1) % 20 == 0) 
				statement += "\n";			
		}
		
		System.out.println(statement);
	}
	
	public void printDeadPlayers() {
		String statement = "Deceased: \n";
		for (int i = 0; i < numDeadPlayers(); i++) {
			statement += deadPlayers.get(i) + ", ";
			
			if ((i+1) % 20 == 0) 
				statement += "\n";			
		}
		
		System.out.println(statement);
	}
	
	public void printAllPlayers() {
		printAlivePlayers();
		printDeadPlayers();
	}
	
	public void namePlayer(String name) {
		name = "[" + name + "]";
		players.set(0, name);
	}
	
	
}
