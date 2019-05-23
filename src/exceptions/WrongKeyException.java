package exceptions;

import javafx.scene.input.KeyCode;

@SuppressWarnings("serial")
public class WrongKeyException extends IllegalArgumentException{

	private String keyType;
	private String customMessage;
	
	public WrongKeyException(KeyCode key) {
		super("The key is not valid.");
		
		keyType = key.getName();
		
		customMessage="The key '"+keyType+"' is invalid";
	}
	
	@Override
	public String getMessage() {
		String msg;
		msg = super.getMessage() + customMessage;
		return msg;
	}

}