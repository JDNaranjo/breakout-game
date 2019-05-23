package ui;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Game;
import model.Player;

public class HallOfFameController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label position;
    
    private Game game;

    @FXML
    void initialize() {
    	List<Player> playersList = new ArrayList<>();
    	try {
    	playersList = game.inOrder();
    	
    	for (int i = 0; i < playersList.size(); i++) {
			System.out.println(""+i+". "+playersList.get(i).getNickname()+"  "+playersList.get(i).getNickname());
			position.setText(position.getText()+i+". "+"\n");
			scoreLabel.setText(position.getText()+playersList.get(i).getScore()+"\n");
			nameLabel.setText(position.getText()+playersList.get(i).getNickname()+". "+"\n");
		}
    	}catch(NullPointerException e) {
    		nameLabel.setText("No hay Jugadores Registrados");
    		System.out.println("No hay Jugadores Registrados");
    		/*position.setVisible(false);
    		scoreLabel.setVisible(false);*/
    	}
    	
    }
    
    public void setGame(Game game) {
    	this.game = game;
    }

	public void setNickname(String nickname) {
		nameLabel.setText(nickname);	
	}

	public void setScore(String score) {
		scoreLabel.setText(score);
	}

	public void setPosition(String position) {
		this.position.setText(position);
	}
    
}
