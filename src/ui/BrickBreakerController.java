package ui;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.WrongKeyException;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Brick;
import model.Game;
import thread.BallMoveThread;
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
    private Game game;
    private ArrayList<Rectangle> bricks = new ArrayList<>();
    
	@FXML
    void initialize() throws InterruptedException {
        MusicThread mt = new MusicThread();
    	mt.start();
    }
	
    @FXML
    void continueNewGame(ActionEvent event) throws IOException, WrongKeyException{

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
    	
    	if(textLevel!=null) {
    		game = new Game(textLevel);
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
    		Parent root = loader.load();
    		GameController gc = loader.getController();
    		Scene scene = new Scene(root);
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    			@Override
    			public void handle(KeyEvent e) {
    				if(e.getCode().equals(KeyCode.A)||e.getCode().equals(KeyCode.LEFT)) {
    					gc.move(4);
    				}else if(e.getCode().equals(KeyCode.D)||e.getCode().equals(KeyCode.RIGHT)) {
    					gc.move(6);
    				}else if(e.getCode().equals(KeyCode.SPACE)) {
    					BallMoveThread bmt = new BallMoveThread(gc);
    					bmt.start();
    				}else {
						throw new WrongKeyException(e.getCode());
    				}
    			}
    		});
    		
    		Color color = Color.RED;
            double brickLife = 100.0;
            if(textLevel.equalsIgnoreCase(Game.EASY_LEVEL)) {
            	game = new Game(Game.EASY_LEVEL);
            }else if(textLevel.equalsIgnoreCase(Game.MEDIUM_LEVEL)) {
            	game = new Game(Game.MEDIUM_LEVEL);
            	color = Color.ORANGERED;
            	brickLife = 200.0;
            }else if(textLevel.equalsIgnoreCase(Game.HARD_LEVEL)){
            	game = new Game(Game.HARD_LEVEL);
            	color = Color.DARKRED;
            	brickLife = 300.0;
            }
            int quantity = game.bricksQuantity();
            System.out.println(""+quantity);
            Brick brick = null;
            for (int i = 0; i < quantity; i++) {
                Brick newBrick = new Brick(brickLife, color, game.generateCooX(), game.generateCooY());
                if(game.getFirst()==null) {
    	    		game.setFirst(newBrick);
    	    		brick = game.getFirst();
    	    	}else {
    	    		brick.setNext(newBrick);
    	    		brick.getNext().setPrev(brick);
    	    		brick = brick.getNext();
    	    	}
            	Rectangle brickShape = new Rectangle(70.0, 30.0);
            	bricks.add(brickShape);
            	brickShape.setFill(color);
            	brickShape.setLayoutX(newBrick.getPosX());
            	brickShape.setLayoutY(newBrick.getPosY());
            	gc.addBrick(brickShape);
            	gc.setBricksArray(bricks);
            	gc.setGame(game);
    		}
    		
    		stage.setTitle("BrickBreaker");
    		stage.setScene(scene);
    		stage.show();
    	}else {
    		labelTxt.setText("Escoja de Nuevo");
    	}
    }

    @FXML
    void newGame(ActionEvent event) {
    	continueButton.setVisible(true);
    	levelMenuButton.setVisible(true);
    }

    @FXML
    void showRanking(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("HoF.fxml"));
		Parent root = loader.load();
		HallOfFameController hofc = loader.getController();
		hofc.setGame(this.game);
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("BrickBreaker");
		stage.setScene(scene);
		stage.show();
    }
    
}
