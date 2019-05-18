package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import thread.MusicThread;

public class BrickBreakerController {

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button newGameButton;

    @FXML
    private Button rankingButton;
    
    @FXML
    private Button continueButton;

    @FXML
    private MenuButton levelMenuButton;
    
    @FXML
    private MenuItem easyItem;

    @FXML
    private MenuItem mediumItem;

    @FXML
    private MenuItem hardItem;
    
    @FXML
    private Label labelTxt;
    
    private String textLevel;
    
	@FXML
    void initialize() throws InterruptedException {
        MusicThread mt = new MusicThread();
    	mt.start();
    }
	
    @FXML
    void continueNewGame(ActionEvent event) throws IOException {
    	try {
    	labelTxt.setVisible(true);
    	EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                textLevel = (((MenuItem)e.getSource()).getText() + ""); 
            } 
        };
        labelTxt.setText(textLevel);
        System.out.println(textLevel+"");
        easyItem.setOnAction(event1);
        mediumItem.setOnAction(event1);
        hardItem.setOnAction(event1);
    	
    	}catch(NullPointerException	e) {
    		labelTxt.setText("Escoja de Nuevo");
    	}
    	
    	if(textLevel!=null) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
    		Parent root = loader.load();
    		GameController gc = loader.getController();
    		Scene scene = new Scene(root);
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    			@Override
    			public void handle(KeyEvent e) {
    				switch (e.getCode()) {  
    		        case A: 
    		            gc.getShip().setLayoutX(gc.getShip().getLayoutX()-10);
    		            break; 
    		        case D: 
    		        	gc.getShip().setLayoutX(gc.getShip().getLayoutX()-10);
    		            break; 
    				default:
    					System.out.println("Movimientos Validos para Derecha e Izquierda");
    					break; 
    		    	}
    					
    			}
    		});
    		
    		stage.setTitle("BrickBreaker");
    		stage.setScene(scene);
    		stage.show();
    	}
    	
    	
    	
    }

    @FXML
    void newGame(ActionEvent event) {
    	continueButton.setVisible(true);
    	levelMenuButton.setVisible(true);
    }

    @FXML
    void showRanking(ActionEvent event) {
    	
    }
    
}
