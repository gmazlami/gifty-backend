package ch.gmazlami.gifty.models.user;

public interface IUser {

	String getId();
	
	String getPhoneNumber();

	String getFirstName();
	
	String getLastName();
	
	String getCountry();
	
	Birthday getBirthDay();
}
