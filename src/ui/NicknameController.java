package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Game;

public class NicknameController {

    @FXML
    private Button continueButton;

    @FXML
    private TextField nicknameBox;
    
    private Game game;
    private double score;

    @FXML
    void showRanking(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("HoF.fxml"));
		Parent root = loader.load();
		HallOfFameController hofc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		hofc.setGame(this.game);
		game.addPlayer(nicknameBox.getText(), score);
		System.out.println(game.getPlayers());
		hofc.setPosition("1.");
		hofc.setScore(game.getPlayers().getScore()+"\n");
		hofc.setNickname(game.getPlayers().getNickname()+". "+"\n");
		
		stage.setTitle("BrickBreaker");
		stage.setScene(scene);
		stage.show();
    }

	public void setGame(Game game) {
		this.game = game;
	}

	public void setScore(double score) {
		this.score = score;
		
	}

}
