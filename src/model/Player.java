package model;

public class Player {

	private String nickname;
	private double score;
	
	private Player right;
	private Player left;
	private Player parent;

	public Player(String nick, double score) {
		nickname = nick;
		this.score = score;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public Player getRight() {
		return right;
	}

	public void setRight(Player right) {
		this.right = right;
	}

	public Player getLeft() {
		return left;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	public Player getParent() {
		return parent;
	}

	public void setParent(Player parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "Nickname: "+nickname+" Score: "+score;
	
	}

}