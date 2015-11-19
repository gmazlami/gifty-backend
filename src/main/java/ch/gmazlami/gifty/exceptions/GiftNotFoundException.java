package ch.gmazlami.gifty.exceptions;

public class GiftNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761095811024504484L;

	
	public GiftNotFoundException(Long id){
		super("There is no Gift with the given id = " + id);
	}
}
