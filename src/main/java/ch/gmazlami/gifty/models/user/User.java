package ch.gmazlami.gifty.models.user;

import org.springframework.data.annotation.Id;

public class User implements IUser {

	@Id
	private String id;
	
	private String phoneNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private Birthday birthday;

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	@Override
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public Birthday getBirthDay() {
		return birthday;
	}
	
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", country=" + country + ", birthday=" + birthday + "]";
	}
	
	

}
