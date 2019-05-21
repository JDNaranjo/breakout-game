package ui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GameController {

    @FXML
    private ImageView ship;

    @FXML
    private Circle ball;
    
    @FXML
    private AnchorPane gamePane;
    
    public static final int LIMITE_ARRIBA=10;
	public static final int LIMITE_ABAJO=420;
	public static final int LIMITE_DERECHA=570;
	public static final int LIMITE_IZQUIERDA=10;
	
	int invertirX=1;
	int invertirY=-1;

	private ArrayList<Rectangle> bricks = new ArrayList<>();
	
	public void move(int key) {
		if(key==4) {
            ship.setLayoutX(ship.getLayoutX()-10);
		}else if(key==6) { 
        	ship.setLayoutX(ship.getLayoutX()+10); 
    	}		
	}

	public void moveBall() {
		
		if(ball.getLayoutY()==390 && ball.getLayoutX()>ship.getLayoutX() && ball.getLayoutX()<ship.getLayoutX()+101) {
			invertirY=-1;
			System.out.println("Rebota");
			ball.setLayoutX(ball.getLayoutX()+invertirX);
			ball.setLayoutY(ball.getLayoutY()+invertirY);
		}
		
		for (int i = 0; i < bricks.size(); i++) {
			if((ball.getLayoutY()==bricks.get(i).getLayoutY() || ball.getLayoutY()==bricks.get(i).getLayoutY()+30)
				&& ball.getLayoutX()>bricks.get(i).getLayoutX() && ball.getLayoutX()<bricks.get(i).getLayoutX()+70) {
				invertirY=-1;
			}
			if((ball.getLayoutX()==bricks.get(i).getLayoutX() || ball.getLayoutX()>bricks.get(i).getLayoutX()+70)
					&& ball.getLayoutY()<bricks.get(i).getLayoutY()+30 && ball.getLayoutY()>bricks.get(i).getLayoutY()) {
				invertirX=-1;
				}
		}
		
		if (ball.getLayoutX()==LIMITE_DERECHA) {
			invertirX=-1;
			
		} else if(ball.getLayoutX()==LIMITE_IZQUIERDA) {
			invertirX=invertirX*-1;
		}
		
		if (ball.getLayoutY()==LIMITE_ABAJO) {
			invertirY=0;
			invertirX=0;
		} else if(ball.getLayoutY()==LIMITE_ARRIBA) {
			invertirY=invertirY*-1;
		}
		
		ball.setLayoutX(ball.getLayoutX()+invertirX);
		ball.setLayoutY(ball.getLayoutY()+invertirY);
		
	}
	
	public void addBrick(Rectangle brick) {
		gamePane.getChildren().add(brick);
	}

	public void setBricksArray(ArrayList<Rectangle> bricks) {
		this.bricks = bricks;;
	}
}
