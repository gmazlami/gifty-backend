package ch.gmazlami.gifty.exceptions;

public class NoSuchUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4628710192976314664L;
	
	public NoSuchUserException(Object userId){
		super("There is no user with id = " + userId);
	}

}
