package thread;

import model.Brick;
import ui.BrickBreakerController;

public class BallMoveThread extends Thread{

	private Brick first;
	private BrickBreakerController bbc;
	
	public BallMoveThread(Brick first, BrickBreakerController bbc) {
		this.first = first;
		this.bbc = bbc;
	}
	
	@Override
	public void run() {
		Brick current = first;
		while(current.getNext()!=null) {
			
		}
	}
	
}
