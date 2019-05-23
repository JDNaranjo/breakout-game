package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private String level;
	public final static String EASY_LEVEL = "Easy";
	public final static String MEDIUM_LEVEL = "Medium";
	public final static String HARD_LEVEL = "Hard";
	
	private Player players;
	private Brick first;

	public Game(String level) {
		this.level = level;
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

	public int bricksQuantity() {
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
	
	public void addPlayer(String nickname, double score){
		  Player player = new Player(nickname, score);

		  if(players==null){
			players = player;
		  }else{
		     Player current = players;
		     boolean added = false;
		      
		     while(!added){
		           if(players.getScore()<player.getScore()){
		               if(current.getRight() == null){
		                  current.setRight(player);
		                  added = true;
		               }else{
		 	          current = current.getRight();
		              }
		           }else{
				if(current.getLeft() == null){
		                  current.setLeft(player);
		                  added = true;
		               }else{
		 	          current = current.getLeft();
		               }
			   } 
		      }
		  }
		}
	
	public List<Player> inOrder(){
		System.out.println(players+" TM_-JDNT- ");
        return inOrder(players); 
    }
	
	private List<Player> inOrder(Player current){
        List<Player> lis= new ArrayList<>();
        if(current != null) {
            List<Player> lis2 = inOrder(current.getLeft());
            List<Player> lis3 = inOrder(current.getRight());
            if(lis2!=null) {
            	lis.addAll(lis2);
            }
            lis.add(current);
            if(lis2!=null) {
            	lis.addAll(lis3);
            }
        }
        return lis;
    }

}