package ch.gmazlami.gifty.exceptions;

public class NoSuchPhoneNumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1484074647596777928L;

	public NoSuchPhoneNumberException(String phoneNumber){
		super("There is no user with the phoneNumber = " + phoneNumber);
	}
	
}
