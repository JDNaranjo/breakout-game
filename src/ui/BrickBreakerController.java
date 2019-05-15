package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Brick;
import model.Game;
import thread.MusicThread;

public class BrickBreakerController {

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button newGameButton;

    @FXML
    private Button rankingButton;

    @FXML
    private Pane gamePane;

    @FXML
    private Circle ball;

    @FXML
    private ImageView ship;
    
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
    
    private Game game;
    
    private String textLevel;
    
	@FXML
    void initialize() throws InterruptedException {
        MusicThread mt = new MusicThread();
    	mt.start();
    }
	
    @FXML
    void continueNewGame(ActionEvent event) {
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
        int quantity = game.generateBricks();
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
        	brickShape.setFill(color);
        	brickShape.setLayoutX(newBrick.getPosX());
        	brickShape.setLayoutY(newBrick.getPosY());
        	gamePane.getChildren().add(brickShape);
		}
    	
    	}catch(NullPointerException	e) {
    		labelTxt.setText("Escoja de Nuevo");
    	}
    	
    	if(textLevel!=null) {
    		menuPane.setVisible(false);
    		gamePane.setVisible(true);
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

    @FXML
    void startGame(KeyEvent event) {
    	
    	switch (event.getCode()) {  
        case A: 
            ship.setLayoutX(ship.getLayoutX()-1);
            break; 
        case D: 
        	ship.setLayoutX(ship.getLayoutX()+1);
            break; 
		default:
			System.out.println("Movimientos Validos para Derecha e Izquierda");
			break; 
    	}
    }
    
}
