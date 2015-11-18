package ch.gmazlami.gifty.models.friends;

public class Friends {

	private String userA;
	private String userB;

	public Friends(String userA, String userB) {
		super();
		this.userA = userA;
		this.userB = userB;
	}
	
	public String getUserA() {
		return userA;
	}
	
	public void setUserA(String userA) {
		this.userA = userA;
	}
	
	public String getUserB() {
		return userB;
	}
	
	public void setUserB(String userB) {
		this.userB = userB;
	}

	@Override
	public String toString() {
		return "Friends [userA=" + userA + ", userB=" + userB + "]";
	}
	
	
	
	
	
}
