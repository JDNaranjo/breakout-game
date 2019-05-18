package ui;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class GameController {

    @FXML
    private ImageView ship;

    @FXML
    private Circle ball;

	public void move(int key) {
		switch (key) {  
        case 4: 
            ship.setLayoutX(ship.getLayoutX()-10);
            break; 
        case 6: 
        	ship.setLayoutX(ship.getLayoutX()+10);
            break;  
    	}		
	}

	public ImageView getShip() {
		return this.ship;
	}
    
}
