package thread;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import ui.GameController;

public class BallMoveThread extends Thread{

	private GameController gc;
	
	public BallMoveThread(GameController gc) {
		this.gc = gc;
	}
	
	@Override
	public void run() {
		Timeline hilo=new Timeline(new KeyFrame(Duration.ZERO, e-> {
			gc.moveBall();
		}),new KeyFrame(Duration.millis(10)));
		
		hilo.setCycleCount(Animation.INDEFINITE);
		hilo.play();
	}
	
}
