package model;

public class Game {

	private String level;
	public final static String EASY_LEVEL = "EASY";
	public final static String MEDIUM_LEVEL = "MEDIUM";
	public final static String HARD_LEVEL = "HARD";
	
	private Player players;
	private Brick first;

	public Game(String level) {

	}

	public String getLevel() {
		return this.level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	public Player getPlayers() {
		return players;
	}

	public void setPlayers(Player players) {
		this.players = players;
	}
	
	public Brick getFirst() {
		return first;
	}

	public void setFirst(Brick first) {
		this.first = first;
	}

	public int generateBricks() {
		int quantity = 0;
		if(level.equalsIgnoreCase(EASY_LEVEL)) {
			quantity = 5+(int) (Math.random()*6);
		}else if(level.equalsIgnoreCase(MEDIUM_LEVEL)) {
			quantity = 10+(int) (Math.random()*6);
		}else if(level.equalsIgnoreCase(HARD_LEVEL)) {
			quantity = 15+(int) (Math.random()*6);
		}
		
		return quantity;
	}
	
	public double generateCooX() {
		
		double x = Math.random()*570;
		
		return x;
	}

	public double generateCooY() {
		
		double y = Math.random()*207;
		
		return y;
	}

}