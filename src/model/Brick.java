package model;

import javafx.scene.paint.Color;

public class Brick {
	
	private double life;
	private Color color;
	private double posY;
	private double posX;
	
	private Brick next;
	private Brick prev;
	
	public Brick(double life, Color color, double posX, double posY) {
		this.life = life;
		this.color = color;
		this.posX = posX;
		this.posY = posY;
	}
	
	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getLife() {
		return life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Brick getNext() {
		return next;
	}
	
	public void setNext(Brick flight) {
		this.next = flight;
	}
	
	public Brick getPrev() {
		return prev;
	}
	public void setPrev(Brick flight) {
		this.prev = flight;
	}

}
